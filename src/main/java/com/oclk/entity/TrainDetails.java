package com.oclk.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "train_details")
public class TrainDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "distance_time")
    private int distanceTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    @JsonManagedReference
    private Train train;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    @JsonManagedReference
    private Station station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direction_id")
    @JsonManagedReference
    private Direction direction;

    public TrainDetails() {}

    public TrainDetails(int distanceTime, Train train, Station station, Direction direction) {
        this.distanceTime = distanceTime;
        this.train = train;
        this.station = station;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistanceTime() {
        return distanceTime;
    }

    public void setDistanceTime(int distanceTime) {
        this.distanceTime = distanceTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "TrainDetails{" +
                "id=" + id +
                ", distanceTime=" + distanceTime +
                ", train=" + train +
                ", station=" + station +
                ", direction=" + direction +
                '}';
    }
}
