/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Sara Selim
 */
public class Order {

    private int id;
    private int totalPrice;
    private Timestamp date;
    private int userId;

    List<UserProduct> product;

    public List<UserProduct> getProduct() {
        return product;
    }

    public void setProduct(List<UserProduct> product) {
        this.product = product;
    }

    public Order() {
    }

    public Order(int id, int totalPrice, Timestamp date, int userId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.date = date;
        this.userId = userId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
