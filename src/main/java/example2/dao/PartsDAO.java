package example2.dao;

import com.sun.istack.internal.Nullable;
import example2.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class PartsDAO {
    private final EntityManager em;

    @Autowired
    public PartsDAO(EntityManager em) {
        this.em = em;
    }
@SuppressWarnings("unchecked")
    public List<Part> all() {
        return em.createQuery("select p from Part p").getResultList();
    }
@Nullable
    public Part find(String partNumber) {
        try {
            return (Part) em.createQuery("select p from Part p where p.partNumber = :partNumber").
                    setParameter("partNumber", partNumber).getSingleResult();
        } catch (NoResultException notFound){
            return null;
        }
    }
    public void createPart(String title,String partNumber) throws Throwable {
        em.getTransaction().begin();
        try {
            Part part=new Part();
            part.setPartNumber(partNumber);
            part.setTitle(title);
            em.persist(part);
            em.getTransaction().commit();
        }
        catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}

