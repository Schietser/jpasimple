package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.connection.EntityManagerProvider;
import org.example.models.Message;
import org.example.models.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    public void createUser(User user){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }

    public Optional<User> readUser(Integer id){

        EntityManager em = EntityManagerProvider.getEntityManager();

        User user = em.find(User.class, id);

        em.close();

        return Optional.ofNullable(user);

    }

    public void deleteUser(User user){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

        em.close();
    }

    public void updateUser(User user){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        em.close();
    }


    public List<User> readAllUsers() {

        EntityManager em = EntityManagerProvider.getEntityManager();
        Query query = em.createQuery("SELECT id, name, phoneNumber, age FROM User");
        return query.getResultList();
    }

    public Optional<User> readUserByPhoneNumber(String phoneNumber) {

        EntityManager em = EntityManagerProvider.getEntityManager();
        Query query = em.createQuery("SELECT id, name, phoneNumber, age FROM User WHERE phoneNumber = "+phoneNumber);
        return Optional.of((User) query.getSingleResult());
    }
}
