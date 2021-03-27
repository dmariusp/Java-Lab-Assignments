package optional;

import optional.command.*;
import optional.shell.Shell;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Shell.addCommand(new AddCommand());
            Shell.addCommand(new ListCommand());
            Shell.addCommand(new LoadCommand());
            Shell.addCommand(new PlayCommand());
            Shell.addCommand(new SaveCommand());
            Shell.runTheShell();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
