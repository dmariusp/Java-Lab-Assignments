package optional.media;

import lombok.Getter;

@Getter

public class Song extends Item {
    private String artist;
    private String songName;

    public Song(String id, String name, String location, String songName, String artist) {
        super(id, name, location);
        this.artist = artist;
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist=" + artist +
                ", songName='" + songName + '\'' +
                " inherits from " + super.toString() +
                '}';
    }
}
