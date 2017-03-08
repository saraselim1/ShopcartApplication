/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.List;

/**
 *
 * @author Sara Selim
 */
public class Cart {
    private int id;
    private int amountOfMoney;
    private int userId;
    List<UserProduct> product;

    public List<UserProduct> getProduct() {
        return product;
    }

    public void setProduct(List<UserProduct> product) {
        this.product = product;
    }
    
    public Cart() {
    }

    public Cart(int amountOfMoney, int userId) {
        this.amountOfMoney = amountOfMoney;
        this.userId = userId;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
