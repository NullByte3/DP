package club.nullbyte3.mediator.chat;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SimpleChatMediator mediator = new SimpleChatMediator();
        ChatClientController a = new ChatClientController(mediator, "Alice");
        ChatClientController b = new ChatClientController(mediator, "Bob");
        ChatClientController c = new ChatClientController(mediator, "Carol");
        a.show();
        b.show();
        c.show();
    }
}
