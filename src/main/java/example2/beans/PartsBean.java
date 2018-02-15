package example2.beans;

import example2.ApplicationEnvironment;
import example2.dao.PartsDAO;
import example2.model.Part;

import javax.persistence.EntityManager;
import java.util.List;

        public class PartsBean {
            private  List<Part> allParts;
            private Part part;
            private int partId;

            public PartsBean (){
    }
            public List<Part> getAllParts(){
                return allParts;
            }

            public void setAllParts(List<Part> allParts) {
                this.allParts = allParts;
            }
        }
