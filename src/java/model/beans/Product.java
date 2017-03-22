/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.io.Serializable;

/**
 *
 * @author Sara Selim
 */
public class Product implements Serializable{

    private int id;
    private String name;
    private String description;
    private int price;
    private int offer;
    private int quantity;
    private int categoryId;
    private String imgMaster;
    private String img1;
    private String img2;
    private String img3;

    public Product() {
    }

    public Product(String name, String description, int price, int offer, int quantity, int categoryId,String imgMaster) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.offer = offer;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.imgMaster=imgMaster;
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

    public String getImgMaster() {
        return imgMaster;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImgMaster(String imgMaster) {
        this.imgMaster = imgMaster;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
    
}
