package optional.command;

import optional.media.Item;
import optional.media.Movie;
import optional.media.Song;
import optional.shell.Shell;

import java.io.IOException;

public class AddCommand extends GenericCommand {
    public AddCommand() {
        super("add");
    }

    private Song newSong(String... arguments) throws IOException {
        if (arguments.length < 6)
            return null;

        var songName = arguments[2];
        var path = Item.path + songName + ".mp3";
        var author = arguments[3];
        var id = arguments[1];
        return new Song(id, songName, path, songName, author);
    }

    private Movie newMovie(String... arguments) throws IOException {
        if (arguments.length < 6)
            return null;

        var movieName = arguments[2];
        var path = Item.path + movieName + ".mp4";
        var author = arguments[4];
        var id = arguments[1];
        var year = arguments[3];
        return new Movie(id, movieName, path, year, author);
    }

    public void run(String... arguments) throws IOException {
        if (arguments.length < 4)
            System.out.print("Invalid number of parameters in add command");

        Item item = null;

        if (arguments[1].equalsIgnoreCase("song"))
            item = newSong(arguments);
        if (arguments[1].equalsIgnoreCase("movie"))
            item = newMovie(arguments);

        if (item == null)
            System.out.print("Failed to create the item");

        Shell.getCatalog().add(item);
    }
}
