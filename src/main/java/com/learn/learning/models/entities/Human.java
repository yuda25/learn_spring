package com.learn.learning.models.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_human")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "name is required")
    @Column(name = "name", length = 50)
    private String name;

    @NotEmpty(message = "hobby is required")
    @Column(name = "hobby", length = 50)
    private String hobby;

    @ManyToOne
    private Status status;

    @ManyToMany
    @JoinTable(
        name = "tbl_human_sick",
        joinColumns = @JoinColumn(name = "human_id"),
        inverseJoinColumns = @JoinColumn(name = "sick_id")
        )
    // @JsonManagedReference
    private Set<Sick> sicks;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Sick> getSicks() {
        return sicks;
    }

    public void setSicks(Set<Sick> sicks) {
        this.sicks = sicks;
    }

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
