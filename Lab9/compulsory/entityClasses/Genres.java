package compulsory.entityClasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "GENRES")
public class Genres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "CHAR")
    private String id;

    @Column(name = "NAME")
    private String name;

    public Genres(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genres() {
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
