package com.optional;

import com.compulsory.Catalog;
import com.compulsory.CatalogUtil;
import com.compulsory.Document;
import com.exceptions.IdNotFoundException;

import java.util.Scanner;

/**
 * Shell Application
 */
public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        Scanner scanner = new Scanner(System.in);
    }

    private void testSaveBinary() {
        Catalog catalog = new Catalog("Java Resources", "catalog.ser");
        Document document = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type", "Slides");
        catalog.addDocument(document);
        CatalogUtil.saveBinary(catalog);
    }

    private void testSavePlaintext() {
        Catalog catalog = new Catalog("Java Resources", "catalog.txt");
        Document document = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type", "Slides");
        catalog.addDocument(document);
        CatalogUtil.saveUsingPlaintext(catalog);
    }

    private void testLoadViewBinary() throws IdNotFoundException {
        try {
            Catalog catalog = CatalogUtil.loadBinary("catalog.ser");
            assert catalog != null;
            Document document = catalog.findById("java1");
            CatalogUtil.view(document);
        } catch (IdNotFoundException e) {
            System.out.println("Not found");
        }
    }

    private void testLoadViewPlaintext() {
        try {
            Catalog catalog = CatalogUtil.loadUsingPlaintext("catalog.txt");
            Document document = catalog.findById("java1");
            CatalogUtil.view(document);
        } catch (IdNotFoundException exception) {
            System.out.println("Not found");
        }
    }

    private void executeCommand(Shell shell, Command command, String[] commandArguments) {
    }


}
