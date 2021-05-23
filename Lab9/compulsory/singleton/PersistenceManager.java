package compulsory.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
    INSTANCE;

    private EntityManagerFactory emf = null;

    PersistenceManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("lab9-persistence");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManagerFactory() {
        if (emf != null)
            emf.close();
    }
}
