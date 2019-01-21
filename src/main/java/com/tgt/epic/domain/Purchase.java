package com.tgt.epic.domain;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Purchase { @JsonProperty("title")
private String title;
    @JsonProperty("tcin")
    private int tcin;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("price")
    private double price;
    @JsonProperty("email")
    private String email;
    @JsonProperty("quantity")
    private int quantity;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTcin() {
        return tcin;
    }

    public void setTcin(int tcin) {
        this.tcin = tcin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
