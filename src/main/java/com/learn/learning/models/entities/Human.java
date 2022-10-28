package com.learn.learning.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "hobby", length = 50)
    private String hobby;

    public Human() {
    
    }

    public Human(long id, String name, String hobby) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // @Override
    // public String toString() {
    //     return "Human [id=" + id + ", name=" + name + ", hobby=" + hobby +"]";
    // }
}
