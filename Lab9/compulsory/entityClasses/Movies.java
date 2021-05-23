package compulsory.entityClasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Accessors(chain = true)
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MOVIES")
@NamedQueries({
        @NamedQuery(name = "Movies.findByName",
                query = "SELECT m FROM Movies m WHERE m.title = :name")
})
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private String ID;
    @Column(name = "TITLE")
    private String TITLE;
    @Id
    @Column(name = "ID", columnDefinition = "CHAR")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @Column(name = "DURATION")
    private String DURATION;
    @Column(name = "SCORE")
    private String SCORE;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "SCORE")
    private Long score;

    public Movies(String id, String title, Long duration, Long score) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.score = score;
    }

    public Movies() {
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getReleaseDate() {
        return this.releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Long getDuration() {
        return this.duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public Long getScore() {
        return this.score;
    }
    public void setScore(Long score) {
        this.score = score;
    }
    public String getID() {
        return this.ID;
    }
    public String getTITLE() {
        return this.TITLE;
    }
    public String getDURATION() {
        return this.DURATION;
    }
    public String getSCORE() {
        return this.SCORE;
    }

}
