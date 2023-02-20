package org.example;

public class TicketRepository {
    private Ticket [] tickets = new Ticket [0];

    public Ticket [] findAll (){
        return tickets;
    }

    public void add (Ticket ticket){
        Ticket [] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++){
            tmp[i] = tickets[i];

        }
        tmp[tmp.length -1] = ticket;
        tickets = tmp;
    }

    private Ticket findById(int findId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == findId) {
                return ticket;
            }
        }
        return null;
    }

    public void removeTicket(int removeId) {
        Ticket foundTicket = findById(removeId);
        if (foundTicket == null){
            throw new NotFoundException(removeId);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != removeId) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
