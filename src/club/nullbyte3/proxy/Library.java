package club.nullbyte3.proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, IDocument> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String content) {
        documents.put(id, new RealDocument(id, content));
    }

    public void addProtectedDocument(String id, String content) {
        RealDocument realDoc = new RealDocument(id, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}
