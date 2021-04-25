package optional.tables;

import lombok.Data;

@Data
public class Genre {
    int genreID;
    String name;

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", name='" + name + '\'' +
                '}';
    }
}