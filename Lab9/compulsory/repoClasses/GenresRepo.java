package compulsory.repoClasses;

import compulsory.entityClasses.Genres;
import compulsory.singleton.PersistenceManager;

import javax.persistence.EntityManager;

public class GenresRepo {
    public Genres findGenreByName(String name) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        return (Genres) entityManager.createQuery("SELECT g FROM Genres g WHERE g.name=?1").setParameter(1, name).getSingleResult();
    }

    public void create (Genres genres) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(genres);
        entityManager.getTransaction().commit();
    }
}

