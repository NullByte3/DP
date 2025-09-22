package club.nullbyte3.visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
