package com.hibernate;

import com.hibernate.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Passenger galal = new Passenger("Ahmed Galal", "Giza, Egypt");
        entityManager.persist(galal);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
