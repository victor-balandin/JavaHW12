package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test

    public void shouldSortTickets (){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager( repo);

        Ticket ticket1 = new Ticket(1,1299, "SVO", "KZN",95);
        Ticket ticket2 = new Ticket(2,2200, "SVO", "KZN",95);
        Ticket ticket3 = new Ticket(3,15000, "SVO", "KJA",290);
        Ticket ticket4 = new Ticket(4,16000, "KJA", "SVO",295);
        Ticket ticket5 = new Ticket(5,1299, "SVO", "KZN",95);
        Ticket ticket6 = new Ticket(6,17000, "KJA", "SVO",295);
        Ticket ticket7 = new Ticket(7,1000, "SVO", "KZN",95);
        Ticket ticket8 = new Ticket(8,16000, "KJA", "SVO",295);
        Ticket ticket9 = new Ticket(9,1200, "SVO", "KZN",95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket [] expected = {ticket7, ticket9, ticket1, ticket5, ticket2};
        Ticket [] actual = manager.findAll("SVO", "KZN");
    }

    @Test

    public void shouldSortTicketsIfNoTicket (){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager( repo);

        Ticket ticket1 = new Ticket(1,1299, "SVO", "KZN",95);
        Ticket ticket2 = new Ticket(2,2200, "SVO", "KZN",95);
        Ticket ticket3 = new Ticket(3,15000, "SVO", "KJA",290);
        Ticket ticket4 = new Ticket(4,16000, "KJA", "SVO",295);
        Ticket ticket5 = new Ticket(5,1299, "SVO", "KZN",95);
        Ticket ticket6 = new Ticket(6,17000, "KJA", "SVO",295);
        Ticket ticket7 = new Ticket(7,1000, "SVO", "KZN",95);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket [] expected = {};
        Ticket [] actual = manager.findAll("DME", "CEK");
    }

    @Test

    public void shouldSortTicketsIfOneTicket (){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager( repo);

        Ticket ticket1 = new Ticket(1,1299, "SVO", "KZN",95);
        Ticket ticket2 = new Ticket(2,2200, "SVO", "KZN",95);
        Ticket ticket3 = new Ticket(3,15000, "SVO", "KJA",290);
        Ticket ticket4 = new Ticket(4,16000, "KJA", "SVO",295);
        Ticket ticket5 = new Ticket(5,1299, "SVO", "KZN",95);
        Ticket ticket6 = new Ticket(6,17000, "KJA", "DME",295);
        Ticket ticket7 = new Ticket(7,1000, "SVO", "KZN",95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket [] expected = {ticket4};
        Ticket [] actual = manager.findAll("KJA", "SVO");
    }


}