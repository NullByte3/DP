package club.nullbyte3.composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getTotalSalary() {
        return components.stream()
                .mapToDouble(OrganizationComponent::getTotalSalary)
                .sum();
    }

    @Override
    public void printXML(StringBuilder builder, int indent) {
        addIndent(builder, indent);
        builder.append(String.format("<department name=\"%s\">\n", name));
        
        for (OrganizationComponent component : components) {
            component.printXML(builder, indent + 1);
        }
        
        addIndent(builder, indent);
        builder.append("</department>\n");
    }
}
