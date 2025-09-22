package club.nullbyte3.visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory pictures = new Directory("pictures");

        root.addElement(documents);
        root.addElement(pictures);

        documents.addElement(new File("report.docx", 1.5));
        documents.addElement(new File("presentation.pptx", 3.2));
        documents.addElement(new File("archive.zip", 10.0));

        pictures.addElement(new File("photo1.jpg", 0.5));
        pictures.addElement(new File("photo2.jpg", 0.8));
        pictures.addElement(new File("logo.png", 0.1));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".jpg");
        root.accept(searchVisitor);
        System.out.println("Found .jpg files:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}
