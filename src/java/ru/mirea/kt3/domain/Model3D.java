package java.ru.mirea.kt3.domain;

import java.util.HashSet;
import java.util.Set;
public class Model3D {
    private final int id;
    private int productId;
    private String filePath;
    private String format;
    private String status;
    private final Set<Tag> tags = new HashSet<>();

    public Model3D(int id, int productId, String filePath, String format, String status) {
        this.id = id;
        this.productId = productId;
        this.filePath = filePath;
        this.format = format;
        this.status = status;
    }

    public int getId() { return id; }
    public int getProductId() { return productId; }
    public String getFilePath() { return filePath; }
    public String getFormat() { return format; }
    public String getStatus() { return status; }
    public Set<Tag> getTags() { return tags; }

    public void addTag(Tag tag) { tags.add(tag); }
    public void setProductId(int productId) { this.productId = productId; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setFormat(String format) { this.format = format; }
    public void setStatus(String status) { this.status = status; }
}