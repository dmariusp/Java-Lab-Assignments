#Lab9's Assignment - Notes

## Compulsory

*[X] Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
 Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).

*[X] Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.

*[X] Create a singleton responsible with the management of an EntityManagerFactory object.

*[X] Define repository clases for your entities (at least one). They must contain the following methods:
    * findById - returns an entity based on its primary key;
    * findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
    

## Optional
*[ ] Add support for charts. A chart has a name, a creation date and an ordered list of movies.
*[X] Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
*[X] Implement both the JDBC and JPA implementations and use an AbstractFactory in order to create the DAO objects (the repositories).
*[X] The application will use JDBC or JPA depending on a parameter given in an initialization file. (At least for one entity!)