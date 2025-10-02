package club.nullbyte3.mediator.chat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class ChatClientController implements ChatClient {
    private final ChatMediator mediator;
    private final String username;
    private final Stage stage = new Stage();
    private final TextArea conversation = new TextArea();
    private final ComboBox<String> recipientBox = new ComboBox<>();
    private final TextField input = new TextField();
    private final Button sendButton = new Button("Send");

    public ChatClientController(ChatMediator mediator, String username) {
        this.mediator = mediator;
        this.username = username;
        conversation.setEditable(false);
        recipientBox.setPromptText("Recipient");
        input.setPromptText("Type a message");
        sendButton.setDefaultButton(true);
        sendButton.setOnAction(e -> onSend());
        input.setOnAction(e -> onSend());
        BorderPane root = new BorderPane();
        root.setCenter(conversation);
        HBox bottom = new HBox(8, recipientBox, input, sendButton);
        bottom.setPadding(new Insets(8));
        recipientBox.setMinWidth(150);
        input.setPrefColumnCount(20);
        root.setBottom(bottom);
        stage.setTitle("Chat - " + username);
        stage.setScene(new Scene(root, 520, 360));
    }

    public void show() {
        stage.show();
        mediator.register(this);
    }

    private void onSend() {
        String to = recipientBox.getValue();
        String msg = input.getText();
        if (to == null || to.trim().isEmpty() || msg == null || msg.trim().isEmpty()) {
            return;
        }
        append("You -> " + to + ": " + msg);
        mediator.send(username, to, msg);
        input.clear();
    }

    private void append(String line) {
        Platform.runLater(() -> {
            if (conversation.getText().isEmpty()) {
                conversation.appendText(line);
            } else {
                conversation.appendText("\n" + line);
            }
        });
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void receive(String from, String message) {
        append(from + " -> You: " + message);
    }

    @Override
    public void refreshRecipients() {
        List<String> users = mediator.getUsernames().stream().filter(u -> !u.equals(username)).sorted().collect(Collectors.toList());
        ObservableList<String> items = FXCollections.observableArrayList(users);
        Platform.runLater(() -> {
            String current = recipientBox.getValue();
            recipientBox.setItems(items);
            if (current != null && users.contains(current)) {
                recipientBox.setValue(current);
            } else if (!users.isEmpty()) {
                recipientBox.getSelectionModel().selectFirst();
            } else {
                recipientBox.setValue(null);
            }
        });
    }
}
