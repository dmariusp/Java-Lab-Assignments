package optional.command;

import optional.catalog.CatalogUtil;
import optional.shell.Shell;

import java.io.IOException;

public class SaveCommand extends GenericCommand {

    public SaveCommand() {
        super("save");
    }

    public void run(String... arguments) throws IOException {
        if (arguments.length != 1)
            System.out.print("Invalid number of parameters in save command");
        CatalogUtil.save(Shell.getCatalog());
    }
}
