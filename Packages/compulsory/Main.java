package com.compulsory;

import com.exceptions.IdNotFoundException;

/**
 * Main Class: Document Management System
 */
public class Main {

    public static void main(String[] args) throws IdNotFoundException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "catalog.ser");
        Document document = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type", "Slides");
        catalog.addDocument(document);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IdNotFoundException {
        Catalog catalog = CatalogUtil.load("catalog.ser");
        assert catalog != null;
        Document document = catalog.findById("java1");
        CatalogUtil.view(document);
    }
}

