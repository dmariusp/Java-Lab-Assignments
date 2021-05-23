package compulsory;

import compulsory.entityClasses.Genres;
import compulsory.entityClasses.Movies;
import compulsory.repoClasses.GenresRepo;
import compulsory.repoClasses.MoviesRepo;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        MoviesRepo moviesRepo = new MoviesRepo();
        Movies movie1 = new Movies("6", "Bad boys", (long)90, (long)7);
        movie1.setReleaseDate(new Date(System.currentTimeMillis()));
        moviesRepo.create(movie1);

        GenresRepo genresRepo = new GenresRepo();

        Genres genre1 = new Genres("4", "Action");
        Genres genre2 = new Genres("5", "Comedy");
        Genres genre3 = new Genres("6", "Thriller");

        genresRepo.create(genre1);
        genresRepo.create(genre2);
        genresRepo.create(genre3);

        System.out.println(moviesRepo.findMovieByName("Bad Boys"));
        System.out.println(moviesRepo.findMovieById("1"));
    }
}
