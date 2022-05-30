package ru.gb.webapp.model;

import java.util.Random;

public class Product {
    private final Long id;
    private final String title;
    private int cost;

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public Integer getCost() {
        return cost;
    }

    public void incCost(){
       cost++;
    }
    public void decCost(){
        cost--;
    }
}
