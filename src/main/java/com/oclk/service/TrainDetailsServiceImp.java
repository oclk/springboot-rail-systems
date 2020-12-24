package com.oclk.service;

import com.oclk.dao.TrainDetailsRepository;
import com.oclk.entity.TrainDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainDetailsServiceImp implements TrainDetailsService {
    @Autowired
    private TrainDetailsRepository trainDetailsRepository;

    @Override
    public List<TrainDetails> findAll() {
        return trainDetailsRepository.findAll();
    }

    @Override
    public TrainDetails findById(int id) {
        Optional<TrainDetails> result = trainDetailsRepository.findById(id);

        TrainDetails trainDetails = null;

        if (result.isPresent()) {
            trainDetails = result.get();
        }
        else {
            // we didn't find the train details
            throw new RuntimeException("Did not find train details id - " + id);
        }

        return trainDetails;
    }

    @Override
    public void save(TrainDetails trainDetails) {
        trainDetailsRepository.save(trainDetails);
    }

    @Override
    public void deleteById(int id) {
        trainDetailsRepository.deleteById(id);
    }

    @Override
    public List<TrainDetails> findByDirectionAndStation(int directionId, int stationId) {
        return trainDetailsRepository.findByDirection_IdAndStation_IdOrderByDistanceTimeAsc(directionId, stationId);
    }
}
