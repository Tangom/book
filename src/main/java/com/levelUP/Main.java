package com.levelUP;

import javax.persistence.*;


public class Main {
    public static void main(String[] args) throws Throwable {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
      EntityManager em = factory.createEntityManager();
      try {
          createUser(em, "root");
          User user = findUser(em, "root");
          if (user == null){
              System.out.println(" User not found");
              return;
      }
                   System.out.println("user = " + user);
          em.refresh(user);
          em.getTransaction().begin();
          try {
              user.setName("Admin");
              em.getTransaction().commit();
          }catch (Throwable t){
              em.getTransaction().rollback();
              throw t;
          }
          System.out.println("user = " + findUser(em,"root"));
      }finally {
      em.close();
      factory.close();
      }
    }
    private static void createUser(EntityManager em,String login) throws Throwable {
em.getTransaction().begin();
try {
    User newUser = new User(login,login);
    em.persist(newUser);
    em.getTransaction().commit();
}catch (Throwable t){
    em.getTransaction().rollback();
    throw t;
}
    }
    public static User findUser (EntityManager em,String login){
        try {
            return (User) em.createQuery("select u from User u where u.login =:login ")
                    .setParameter("login", login)
                    .getSingleResult();
        }catch (NoResultException e){
return null;
        }
    }
}