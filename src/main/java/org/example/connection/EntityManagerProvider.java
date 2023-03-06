package org.example.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {


   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("messagedb");

   private static EntityManager getEntityManager(){
       return emf.createEntityManager();
   }


}
