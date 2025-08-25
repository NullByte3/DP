package club.nullbyte3.abstractfactory;

public abstract class Checkbox extends UIElement {
    protected boolean checked;

    public Checkbox(String text) {
        super(text);
        this.checked = false;
    }

    public void toggle() {
        checked = !checked;
    }
}
