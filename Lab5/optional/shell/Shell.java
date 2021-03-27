package optional.shell;

import lombok.Data;
import optional.catalog.Catalog;
import optional.command.GenericCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

@Data

public class Shell {


    static Catalog catalog = new Catalog("shellCatalog", "C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//shellCatalog.ser");
    static Map<String, GenericCommand> shellCommands = new LinkedHashMap<>(15);

    public static Catalog getCatalog() {
        return catalog;
    }

    private static boolean commandDoesntExistForShell(String command) {
        for (var shellCommand : shellCommands.keySet())
            if (shellCommand.equals(command))
                return false;
        return true;
    }

    public static void addCommand(GenericCommand command) {
        if (commandDoesntExistForShell(command.getCommand()))
            shellCommands.put(command.getCommand(), command);

    }

    public static void runTheShell() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            System.out.print("<>_");
            input = reader.readLine();
            if (input.equals("quit"))
                break;

            var inputCommand = input.split(" ");
            if (commandDoesntExistForShell(inputCommand[0])) {
                System.out.print("Invalid command!");
            }

            shellCommands.get(inputCommand[0]).run(inputCommand);
        } while (true);


    }
}
