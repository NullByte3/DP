package club.nullbyte3.composite;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void add(OrganizationComponent component);
    public abstract void remove(OrganizationComponent component);
    public abstract double getTotalSalary();
    public abstract void printXML(StringBuilder builder, int indent);

    protected void addIndent(StringBuilder builder, int indent) {
        builder.append("    ".repeat(indent));
    }

    public String getName() {
        return name;
    }
}
