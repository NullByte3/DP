package club.nullbyte3.proxy;

import java.util.Date;

public class RealDocument implements IDocument {
    private final String id;
    private final Date creationDate;
    private final String content;

    public RealDocument(String id, String content) {
        this.id = id;
        this.content = content;
        this.creationDate = new Date();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
