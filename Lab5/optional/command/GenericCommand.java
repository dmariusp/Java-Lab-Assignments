package optional.command;

import lombok.Data;

import java.io.IOException;
import java.util.Objects;

@Data
public abstract class GenericCommand {

    String command;

    public abstract void run(String... arguments) throws IOException;

    GenericCommand(String command) {
        this.command = command;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GenericCommand g = (GenericCommand) o;
        return Objects.equals(command, g.command);
    }

    public int hashCode() {
        return Objects.hash(command);
    }
}
