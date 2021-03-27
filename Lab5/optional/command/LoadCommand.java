package optional.command;

import optional.catalog.CatalogUtil;
import optional.shell.Shell;

import java.io.IOException;

public class LoadCommand extends GenericCommand {

    public LoadCommand() {
        super("load");
    }

    public void run(String... arguments) throws IOException {
        if (arguments.length != 1)
            System.out.print("Invalid number of parameters in load command");
        CatalogUtil.load(arguments[1]);
    }
}
