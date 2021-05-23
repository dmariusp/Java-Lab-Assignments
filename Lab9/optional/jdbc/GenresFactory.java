package optional.jdbc;

import compulsory.entityClasses.Genres;

import java.sql.Connection;
import java.sql.SQLException;

public class GenresFactory implements AbstractFactory<Genres>{
    private Connection connection;

    public GenresFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Genres entity){
        try {
            GenresController gc = new GenresController(connection);
            gc.create(entity);
            System.out.println("Entity created");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
