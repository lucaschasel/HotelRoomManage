package main.hotelmanage.model;

public class Room {
    private int id;
    private int type;
    private int price;
    private String info;
    private int hotelId;

    public Room(int id, int type, int price, String info, int hotelId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.info = info;
        this.hotelId = hotelId;
    }

    public Room(int type, int price, String info, int hotelId) {
        this.type = type;
        this.price = price;
        this.info = info;
        this.hotelId = hotelId;
    }

    // Getters and Setters
    // ...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
