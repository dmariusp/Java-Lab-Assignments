package optional.command;

import optional.shell.Shell;

import java.io.IOException;

public class ListCommand extends GenericCommand {

    public ListCommand() {
        super("list");
    }

    public void run(String... arguments) throws IOException {
        if (arguments.length != 1)
            System.out.print("Invalid number of parameters in list command");
        System.out.println(Shell.getCatalog());
    }
}
