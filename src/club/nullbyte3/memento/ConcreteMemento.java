package club.nullbyte3.memento;

import javafx.scene.paint.Paint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConcreteMemento implements Memento {
    private final Paint color1;
    private final Paint color2;
    private final Paint color3;
    private final boolean selected;
    private final LocalDateTime timestamp;
    private final String description;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ConcreteMemento(Paint color1, Paint color2, Paint color3, boolean selected, String description) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.selected = selected;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public Paint getColor1() {
        return color1;
    }

    public Paint getColor2() {
        return color2;
    }

    public Paint getColor3() {
        return color3;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return timestamp.format(formatter) + " - " + description;
    }
}
