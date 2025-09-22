package club.nullbyte3.proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addUnprotectedDocument("doc-unprotected-01", "random free document");
        library.addProtectedDocument("doc-protected-01", "protected document");

        User alice = new User("alice");
        User bob = new User("bob");

        AccessControlService.getInstance().grantAccess("doc-protected-01", "alice");

        System.out.println("--- Bob trying to access documents ---");
        tryToAccessDocument(library, "doc-unprotected-01", bob);
        tryToAccessDocument(library, "doc-protected-01", bob);

        System.out.println("\n--- Alice trying to access documents ---");
        tryToAccessDocument(library, "doc-unprotected-01", alice);
        tryToAccessDocument(library, "doc-protected-01", alice);
    }

    private static void tryToAccessDocument(Library library, String docId, User user) {
        IDocument doc = library.getDocument(docId);
        System.out.println("User '" + user.getUsername() + "' accessing document '" + docId + "'");
        System.out.println("  Creation Date: " + doc.getCreationDate());
        try {
            System.out.println("  Content: " + doc.getContent(user));
        } catch (AccessDeniedException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }
}
