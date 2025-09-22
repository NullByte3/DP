package club.nullbyte3.memento;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class HistoryWindow extends Stage {
    public HistoryWindow(ObservableList<Memento> history, Consumer<Memento> onStateSelected, Runnable onWindowClose) {
        setTitle("History");

        ListView<Memento> historyListView = new ListView<>(history);
        historyListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                onStateSelected.accept(newVal);
            }
        });

        StackPane root = new StackPane(historyListView);
        Scene scene = new Scene(root, 300, 400);
        setScene(scene);
        
        setOnCloseRequest(event -> onWindowClose.run());
    }
}
