package club.nullbyte3.memento;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Stack;

public class History {
    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();
    private final ObservableList<Memento> historyList = FXCollections.observableArrayList();

    public void save(Memento memento) {
        undoStack.push(memento);
        redoStack.clear();
        historyList.setAll(undoStack);
    }

    public Memento undo(Memento currentState) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            Memento lastState = undoStack.pop();
            historyList.setAll(undoStack);
            return lastState;
        }
        return null;
    }

    public Memento redo(Memento currentState) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            Memento nextState = redoStack.pop();
            historyList.setAll(undoStack);
            return nextState;
        }
        return null;
    }

    public ObservableList<Memento> getHistoryList() {
        return FXCollections.unmodifiableObservableList(historyList);
    }
}
