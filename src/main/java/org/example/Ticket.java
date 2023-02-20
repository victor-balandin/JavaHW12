package org.example;

public class Ticket  implements Comparable <Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int TravelTime;

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        TravelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTravelTime() {
        return TravelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.getPrice()){
            return -1;
        }
        if (price > o.getPrice()){
            return 1;
        }
        return 0;
    }
}
