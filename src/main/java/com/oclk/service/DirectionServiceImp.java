package com.oclk.service;

import com.oclk.dao.DirectionRepository;
import com.oclk.entity.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionServiceImp implements DirectionService {
    @Autowired
    private DirectionRepository directionRepository;

    @Override
    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Override
    public Direction findById(int id) {
        Optional<Direction> result = directionRepository.findById(id);

        Direction direction = null;

        if (result.isPresent()) {
            direction = result.get();
        }
        else {
            // we didn't find the direction
            throw new RuntimeException("Did not find direction id - " + id);
        }

        return direction;
    }

    @Override
    public void save(Direction direction) {
        directionRepository.save(direction);
    }

    @Override
    public void deleteById(int id) {
        directionRepository.deleteById(id);
    }
}
