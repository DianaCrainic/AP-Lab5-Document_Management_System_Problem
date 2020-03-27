package com.compulsory;

import com.exceptions.IdNotFoundException;
import com.exceptions.UniqueIdentityException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Catalog class: manages a collection of Documents
 */
public class Catalog implements Serializable {
    private String name;
    private String path;

    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
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

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * OPTIONAL(5th TASK)
     */
    public void addDocument(Document doc) {
        if (documents.contains(doc))
            throw new UniqueIdentityException("This document already exists");
        documents.add(doc);
    }

    /**
     * find a document using an id
     * OPTIONAL (5th TASK)
     * @param id of one particular document
     * @return the document with this id
     */
    public Document findById(String id) throws IdNotFoundException {
        for (Document document : documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        throw new IdNotFoundException(id + " not found");
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }
}
