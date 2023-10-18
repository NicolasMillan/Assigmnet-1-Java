package com.example.assignmentone;

public class Motorcycle {
    private int modelId;
    private String brand;
    private int cc, hp, topSpeed;
    private double Price;

    //Constructor
    public Motorcycle (int modelId, String brand, int cc, int hp, int topSpeed, double price){
        setModelId(modelId);
        setBrand(brand);
        setCc(cc);
        setHp(hp);
        setTopSpeed(topSpeed);
        setPrice(price);
    }

    //Getters & Setters


    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "modelId=" + modelId +
                ", brand='" + brand + '\'' +
                ", cc=" + cc +
                ", hp=" + hp +
                ", topSpeed=" + topSpeed +
                ", Price=" + Price +
                '}';
    }
}
