/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Sara Selim
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private int offer;
    private int quantity;
    private int categoryId;

    public Product() {
    }

    public Product(String name, String description, int price, int offer, int quantity, int categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.offer = offer;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
}
