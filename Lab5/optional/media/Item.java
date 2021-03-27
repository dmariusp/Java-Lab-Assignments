package optional.media;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;


@EqualsAndHashCode
@Getter

public abstract class Item implements Serializable {
    public static final String path = "C://Users//Marius-Paul//Desktop//Materiale//Anul 2//Semestrul 2//PROGRAMARE AVANSATA//Lab5_media//";
    protected String id;
    protected String name;
    protected String location;

    public Item(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
