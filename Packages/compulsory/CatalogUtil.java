package com.compulsory;

import java.awt.*;
import java.beans.XMLDecoder;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * CatalogUtil class: is saving, loading and viewing of contents for a file
 * save method: saves the given object in a file in binary or plaintext representation
 * load method: loads the given object in a file in binary or plaintext representation
 * view method: views the given object in a file in binary representation
 */
public class CatalogUtil {
    /**
     * binarySave method: saves the catalog to an external file, using binary representation
     */
    public static void saveBinary(Catalog catalog) {
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
     * OPTIONAL (1ST TASK)
     * plaintextSave: saves the object in a file in a plaintext representation
     */
    public static void saveUsingPlaintext(Catalog catalog) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(catalog.getPath()));
            pw.print(catalog);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void save(Catalog catalog) {
        saveBinary(catalog);
        //plaintextSave(catalog);
    }

    /**
     * loads the given object in a file in binary representation
     */
    public static Catalog loadBinary(String path) {
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
     * OPTIONAL (1ST TASK)
     * loads the given object in a file in plaintext representation
     */
    public static Catalog loadUsingPlaintext(String path) {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
            return (Catalog) decoder.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Catalog load(String path) {
        return loadBinary(path);
        //return plaintextLoad(path);
    }


    /**
     * view method: opens a document using the native operating system application (using Desktop class)
     */
    public static void view(Document document) {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URL(document.getPath()).toURI();
            desktop.browse(uri);
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }
}

