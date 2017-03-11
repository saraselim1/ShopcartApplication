/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Sara Selim
 */
public class Order {

    private int id;
    private int totalPrice;
    private Date date;
    private int userId;

    public void setId(int id) {
        this.id = id;
    }
    List<UserProduct> product;

    public List<UserProduct> getProduct() {
        return product;
    }

    public void setProduct(List<UserProduct> product) {
        this.product = product;
    }

    public Order() {
    }

    public Order(int id,int totalPrice, Date date, int userId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
