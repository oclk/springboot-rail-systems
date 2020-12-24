package com.oclk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "direction")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direction")
    @JsonBackReference
    private List<TrainDetails> trainDetails;

    public Direction() {}

    public Direction(String name) {
        this.name = name;
    }

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

    public List<TrainDetails> getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(List<TrainDetails> trainDetails) {
        this.trainDetails = trainDetails;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainDetails=" + trainDetails +
                '}';
    }
}
