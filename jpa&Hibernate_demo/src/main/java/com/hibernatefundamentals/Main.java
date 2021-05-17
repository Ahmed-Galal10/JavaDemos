package com.hibernatefundamentals;

import com.hibernatefundamentals.airport.Passenger;
import com.hibernatefundamentals.airport.Airport;
import com.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Airport airport = new Airport(1, "Cairo");

        Passenger galal = new Passenger(1, "Ahmed Galal");
        galal.setAirport(airport);
        airport.addPassenger(galal);

        Passenger salah = new Passenger(2, "Mo Salah");
        salah.setAirport(airport);
        airport.addPassenger(salah);

        Ticket ticket1 = new Ticket(1, "AA1234");
        ticket1.setPassenger(galal);

        Ticket ticket2 = new Ticket(2, "BB5678");
        ticket2.setPassenger(galal);

        galal.addTicket(ticket1);
        galal.addTicket(ticket2);

        Ticket ticket3 = new Ticket(3, "CC0987");
        ticket3.setPassenger(salah);
        salah.addTicket(ticket3);

        em.persist(airport);
        em.persist(galal);
        em.persist(salah);

        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();
        emf.close();

    }
}
