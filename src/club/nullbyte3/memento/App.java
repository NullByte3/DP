package club.nullbyte3.memento;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
    private final ShapeModel model = new ShapeModel();
    private final History history = new History();
    private boolean isRestoring = false;
    private HistoryWindow historyWindow;

    @Override
    public void start(Stage primaryStage) {
        saveState("Initial state");

        primaryStage.setTitle("Memento Pattern Example");

        Rectangle rect1 = createBoundRectangle(model.color1Property());
        Rectangle rect2 = createBoundRectangle(model.color2Property());
        Rectangle rect3 = createBoundRectangle(model.color3Property());
        CheckBox checkBox = new CheckBox("Selected");
        checkBox.selectedProperty().bindBidirectional(model.selectedProperty());

        HBox shapes = new HBox(10, rect1, rect2, rect3);
        VBox root = new VBox(10, shapes, checkBox);
        Scene scene = new Scene(root, 400, 150);

        setupStateChangeListeners();
        setupKeyHandlers(scene);

        primaryStage.setScene(scene);
        primaryStage.show();

        showHistoryWindow(primaryStage);
    }

    private Rectangle createBoundRectangle(javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint> colorProperty) {
        Rectangle rect = new Rectangle(100, 100);
        rect.fillProperty().bind(colorProperty);
        rect.setOnMouseClicked(_ -> {
            ColorPicker colorPicker = new ColorPicker((Color) colorProperty.get());
            colorPicker.setOnAction(_ -> colorProperty.set(colorPicker.getValue()));
            VBox colorBox = new VBox(colorPicker);
            Stage colorStage = new Stage();
            colorStage.setScene(new Scene(colorBox));
            colorStage.show();
        });
        return rect;
    }

    private void setupStateChangeListeners() {
        ChangeListener<Object> changeListener = (_, _, _) -> saveStateFromUIChange();
        model.color1Property().addListener(changeListener);
        model.color2Property().addListener(changeListener);
        model.color3Property().addListener(changeListener);
        model.selectedProperty().addListener(changeListener);
    }

    private void saveStateFromUIChange() {
        if (!isRestoring) {
            String desc = String.format("Color1: %s, Color2: %s, Color3: %s, Selected: %b",
                    model.color1Property().get(), model.color2Property().get(), model.color3Property().get(), model.selectedProperty().get());
            saveState(desc);
        }
    }

    private void saveState(String description) {
        history.save(model.save(description));
    }

    private void setupKeyHandlers(Scene scene) {
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), this::undo);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), this::redo);
    }

    private void undo() {
        Memento currentState = model.save("Before undo");
        Memento previousState = history.undo(currentState);
        if (previousState != null) {
            restoreState(previousState);
        }
    }

    private void redo() {
        Memento currentState = model.save("Before redo");
        Memento nextState = history.redo(currentState);
        if (nextState != null) {
            restoreState(nextState);
        }
    }

    private void restoreState(Memento memento) {
        isRestoring = true;
        model.restore(memento);
        isRestoring = false;
    }
    
    private void showHistoryWindow(Stage owner) {
        historyWindow = new HistoryWindow(history.getHistoryList(), this::restoreState, () -> historyWindow = null);
        historyWindow.initOwner(owner);
        historyWindow.show();
    }
}
