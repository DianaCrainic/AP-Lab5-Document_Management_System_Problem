package com.compulsory;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CatalogUtil {
    /**
     * save method: saves the catalog to an external file, using object serialization
     */
    public static void save(Catalog catalog) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(catalog.getPath()));
            out.writeObject(catalog);
        } catch (FileNotFoundException exception) {
            System.out.println(catalog.getPath() + " not found");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * load method: loads the catalog from an external file.
     * @param path the location where is stored the catalog
     * @return the loaded catalog
     */
    public static Catalog load(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return (Catalog) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
        return null;
    }


    /**
     * view method: opens a document using the native operating system application (using Desktop class)
     */
    public static void view(Document document) {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URL(document.getLocation()).toURI();
            desktop.browse(uri);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

