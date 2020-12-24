package com.oclk.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "wagon")
public class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private int name;

    @Column(name = "count_of_people")
    private int countOfPeople;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    @JsonManagedReference
    private Train train;

    public Wagon() {}

    public Wagon(int name, int countOfPeople) {
        this.name = name;
        this.countOfPeople = countOfPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "id=" + id +
                ", name=" + name +
                ", countOfPeople=" + countOfPeople +
                ", train=" + train +
                '}';
    }
}
