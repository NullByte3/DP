package club.nullbyte3.composite;

public class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void printXML(StringBuilder builder, int indent) {
        addIndent(builder, indent);
        builder.append(String.format("<employee name=\"%s\" salary=\"%.2f\"/>\n", name, salary));
    }
}
