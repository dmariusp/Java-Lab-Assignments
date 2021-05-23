package optional;

import compulsory.singleton.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Generic class which helps us create or find by id an element in our database
 *
 * @param <S> is the type of object that will make the query
 */
public class AbstractRepository<S>{
    public S create(S entity){
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
        //returns the saved entity
    }
}
