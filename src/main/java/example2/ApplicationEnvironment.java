package example2;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationEnvironment {
    private final EntityManagerFactory emf;
    private static final ApplicationEnvironment instance =new ApplicationEnvironment();

    private ApplicationEnvironment() {
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public static ApplicationEnvironment getInstance() {
        return instance;
    }
}
