package com.oclk.service;

import com.oclk.dao.TrainRepository;
import com.oclk.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImp implements TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Override
    public Train findById(int id) {
        Optional<Train> result = trainRepository.findById(id);

        Train train = null;

        if (result.isPresent()) {
            train = result.get();
        }
        else {
            // we didn't find the train
            throw new RuntimeException("Did not find train id - " + id);
        }

        return train;
    }

    @Override
    public void save(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void deleteById(int id) {
        trainRepository.deleteById(id);
    }
}
