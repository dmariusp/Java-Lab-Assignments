package compulsory;

import compulsory.catalog.Catalog;
import compulsory.catalog.CatalogUtil;
import compulsory.media.Movie;
import compulsory.media.Song;

import java.io.IOException;

public class MainCompulsory {
    public static void main(String args[]) throws IOException {
        MainCompulsory app = new MainCompulsory();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Colection", "C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//catalog.ser");
        var song = new Song("gotcha", "hehe", "C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//Rick Astley - Never Gonna Give You Up.mp3", "Never Gonna Give You Up", "RickAstley");
        var movie = new Movie("alsoGotcha", "heheMovie", "C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//Rick Astley  Never Gonna Give You Up Video.mp4", "2009", "RickAstley");
        catalog.add(song);
        catalog.add(movie);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.load("C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//catalog.ser");
        CatalogUtil.view(catalog.findById("gotcha"));
        CatalogUtil.view(catalog.findById("alsoGotcha"));
    }
}
