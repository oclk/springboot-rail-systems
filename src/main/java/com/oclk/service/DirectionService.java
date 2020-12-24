package com.oclk.service;

import com.oclk.entity.Direction;

import java.util.List;

public interface DirectionService {
    public List<Direction> findAll();

    public Direction findById(int id);

    public void save(Direction direction);

    public void deleteById(int id);
}
