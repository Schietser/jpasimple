package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.connection.EntityManagerProvider;
import org.example.models.Message;

import java.util.List;
import java.util.Optional;

public class MessageRepository {

    public void createMessage(Message message){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();

        em.close();
    }

    public Optional<Message> readMessage(Integer id){

        EntityManager em = EntityManagerProvider.getEntityManager();

        Message message = em.find(Message.class, id);

        em.close();

        return Optional.ofNullable(message);

    }

    public List<Message> readAllMessages(){
        EntityManager em = EntityManagerProvider.getEntityManager();
        Query query = em.createQuery("SELECT id, sender, subject, body FROM Message");
        return query.getResultList();
    }

    public void deleteMessage(Message message){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.remove(message);
        em.getTransaction().commit();

        em.close();
    }

    public void updateMessage(Message message){

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.merge(message);
        em.getTransaction().commit();

        em.close();
    }


}
