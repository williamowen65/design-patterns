public class Document implements Prototype<Document> {
    private String title;
    private String body;

    public Document(String title, String body) {
        this.title = title;
        this.body = body;
    }

    private Document(Document source) {
        this.title = source.title;
        this.body = source.body;
    }

    @Override
    public Document copy() {
        return new Document(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Document{title='" + title + "', body='" + body + "'}";
    }
}
