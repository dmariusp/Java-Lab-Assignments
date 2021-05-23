package optional;

import compulsory.entityClasses.Genres;
import compulsory.entityClasses.Movies;
import optional.jdbc.DataBaseConnection;
import optional.jdbc.GenresFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);
        System.out.println("How you want db, JDBC/JPA? (1/2)");
        int model = in.nextInt();
        if(model == 1){
            Connection connection = DataBaseConnection.getInstance().getConnection();
            GenresFactory gf = new GenresFactory(connection);
            gf.create(new Genres("7", "Thriller"));
            connection.close();
        }
        else{
            AbstractRepository<Genres>genresRepository = new AbstractRepository<>();
            Genres gen1 = genresRepository.create(new Genres("7", "Fantasy"));

            AbstractRepository<Movies>moviesRepository = new AbstractRepository<>();
        }


    }

}
