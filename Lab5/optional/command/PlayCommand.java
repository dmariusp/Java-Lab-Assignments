package optional.command;

import optional.catalog.CatalogUtil;
import optional.shell.Shell;

import java.io.IOException;

public class PlayCommand extends GenericCommand {

    public PlayCommand() {
        super("play");
    }

    public void run(String... arguments) throws IOException {
        if (arguments.length != 1)
            System.out.print("Invalid number of parameters in play command");
        CatalogUtil.view(Shell.getCatalog().findById(arguments[1]));
    }
}
