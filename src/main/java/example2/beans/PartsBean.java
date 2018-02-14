package example2.beans;

import example2.ApplicationEnvironment;
import example2.dao.PartsDAO;
import example2.model.Part;

import javax.persistence.EntityManager;
import java.util.List;

        public class PartsBean {
            private final List<Part> allParts;
            private Part part;
            private int partId;

            public PartsBean (){
                EntityManager em = ApplicationEnvironment.getInstance().getEmf().createEntityManager();
                try{
            allParts=new PartsDAO(em).all();
        } finally {
            em.close();
        }
    }

            public int getPartId() {
                return partId;
            }

            public void setPartId(int partId) {
                this.partId = partId;
            }

            public Part getPart() {
                if (part == null) {
                    EntityManager em = ApplicationEnvironment.getInstance().getEmf().createEntityManager();
                    try{
                        part = em.find(Part.class,partId);
                    } finally {
                        em.close();
                    }
                }
                return part;
            }

            public List<Part> getAllParts(){
                return allParts;
            }
}
