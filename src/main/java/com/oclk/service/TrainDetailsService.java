package com.oclk.service;

import com.oclk.entity.TrainDetails;

import java.util.List;

public interface TrainDetailsService {
    public List<TrainDetails> findAll();

    public TrainDetails findById(int id);

    public void save(TrainDetails trainDetails);

    public void deleteById(int id);

    public List<TrainDetails> findByDirectionAndStation(int directionId, int stationId);
}
