package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Resource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Resource(String name) {
        this.name = name;
    }

    public Resource(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
