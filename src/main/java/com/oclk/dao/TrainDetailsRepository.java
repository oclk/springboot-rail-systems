package com.oclk.dao;

import com.oclk.entity.TrainDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Integer> {
    public List<TrainDetails> findByDirection_IdAndStation_IdOrderByDistanceTimeAsc(int directionId, int stationId);
}
