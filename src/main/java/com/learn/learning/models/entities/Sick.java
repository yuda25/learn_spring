package com.learn.learning.models.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tbl_sick")
public class Sick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sicks")
    private Set<Human> humans;

    public Set<Human> getHumans() {
        return humans;
    }
    public void setHumans(Set<Human> humans) {
        this.humans = humans;
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

    
}
