package club.nullbyte3.composite;

public class Main {
    public static void main(String[] args) {
        // the main company?
        Department organization = new Department("TechCorp");

        // random demo departments
        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");
        Department backend = new Department("Backend");
        Department frontend = new Department("Frontend");

        // john does.
        Employee cto = new Employee("John Doe", 150000);
        Employee backendDev1 = new Employee("Jane Smith", 100000);
        Employee backendDev2 = new Employee("Bob Wilson", 95000);
        Employee frontendDev1 = new Employee("Alice Brown", 90000);
        Employee salesRep1 = new Employee("Charlie Davis", 85000);
        Employee salesRep2 = new Employee("Eve Anderson", 82000);

        // do the structures.
        organization.add(cto);
        organization.add(engineering);
        organization.add(sales);
        engineering.add(backend);
        engineering.add(frontend);
        backend.add(backendDev1);
        backend.add(backendDev2);
        frontend.add(frontendDev1);
        sales.add(salesRep1);
        sales.add(salesRep2);

        // example of what you can do.
        System.out.println("Total organization salary: $" + organization.getTotalSalary());

        // build using xml.
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        organization.printXML(xmlBuilder, 0);
        System.out.println("\nOrganization Structure in XML:");
        System.out.println(xmlBuilder);
    }
}
