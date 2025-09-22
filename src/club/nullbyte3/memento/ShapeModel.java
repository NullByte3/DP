package club.nullbyte3.memento;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ShapeModel {
    private final ObjectProperty<Paint> color1 = new SimpleObjectProperty<>(Color.RED);
    private final ObjectProperty<Paint> color2 = new SimpleObjectProperty<>(Color.GREEN);
    private final ObjectProperty<Paint> color3 = new SimpleObjectProperty<>(Color.BLUE);
    private final BooleanProperty selected = new SimpleBooleanProperty(false);

    public ObjectProperty<Paint> color1Property() {
        return color1;
    }

    public ObjectProperty<Paint> color2Property() {
        return color2;
    }

    public ObjectProperty<Paint> color3Property() {
        return color3;
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void restore(Memento memento) {
        if (memento instanceof ConcreteMemento) {
            ConcreteMemento concreteMemento = (ConcreteMemento) memento;
            this.color1.set(concreteMemento.getColor1());
            this.color2.set(concreteMemento.getColor2());
            this.color3.set(concreteMemento.getColor3());
            this.selected.set(concreteMemento.isSelected());
        }
    }

    public Memento save(String changeDescription) {
        return new ConcreteMemento(
                color1.get(),
                color2.get(),
                color3.get(),
                selected.get(),
                changeDescription
        );
    }
}
