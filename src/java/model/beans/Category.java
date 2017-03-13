/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Sara Selim
 */
public class Category {

    private int id;
    private String name;
    private String description;
    private int productNum;
    Vector<Product> products;

    public Category() {
    }

    public Category(String name, String description, int productNum, Vector<Product> products) {
        this.name = name;
        this.description = description;
        this.productNum = productNum;
        this.products = products;
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

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

}
