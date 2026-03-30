package org.example;

public class CleaningProduct {
    private int id;
    private String name;
    private String brand;
    private String purpose;
    private double price;
    private String volume;

    public CleaningProduct() {}

    public CleaningProduct(int id, String name, String brand, String purpose, double price, String volume) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.purpose = purpose;
        this.price = price;
        this.volume = volume;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getVolume() { return volume; }
    public void setVolume(String volume) { this.volume = volume; }
}