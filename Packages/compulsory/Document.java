package com.compulsory;

import com.exceptions.PathFormatException;

import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Document class: represents an entry in the Catalog
 */
public class Document implements Serializable {
    private String id;
    private String name;
    private String path;

    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    /**
     * OPTIONAL (5th TASK)
     */
    public void setPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException ex) {
            System.err.println(ex);
            throw new PathFormatException("Path format is not valid");

        }
        this.path = path;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                '}';
    }
}
