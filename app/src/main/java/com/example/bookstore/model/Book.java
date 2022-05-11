package com.example.bookstore.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String name,author,description,imgUrl;
    private int price;
    private int drawableResources;

    public Book(int drawableResources,String name) {
        this.drawableResources = drawableResources;
        this.name = name;
    }

    public Book(int drawableResources) {
        this.drawableResources = drawableResources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDrawableResources() {
        return drawableResources;
    }

    public void setDrawableResources(int drawableResources) {
        this.drawableResources = drawableResources;
    }

    public Book(String name, String author, String description, String imgUrl, int price, int drawableResources) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.drawableResources = drawableResources;
    }
}
