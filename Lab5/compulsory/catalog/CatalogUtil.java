package compulsory.catalog;

import compulsory.media.Item;

import java.awt.*;
import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) {
        FileInputStream fin;
        ObjectInputStream oin;
        Catalog c = null;

        try {
            fin = new FileInputStream(path);
            oin = new ObjectInputStream(fin);
            Catalog newCatalog = (Catalog) oin.readObject();
            c = new Catalog(newCatalog.getName(), newCatalog.getPath(), newCatalog.getItems());

            fin.close();
            oin.close();
        } catch (IOException i) {
            i.printStackTrace();
            return c;
        } catch (ClassNotFoundException classEx) {
            System.out.println("Catalog class not found");
            classEx.printStackTrace();
            return c;
        }
        return c;
    }

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
        try {
            File newFile = new File(item.getLocation());
            desktop.open(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
