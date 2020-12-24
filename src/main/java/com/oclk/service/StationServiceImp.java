package com.oclk.service;

import com.oclk.dao.StationRepository;
import com.oclk.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImp implements StationService {
    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station findById(int id) {
        Optional<Station> result = stationRepository.findById(id);

        Station station = null;

        if (result.isPresent()) {
            station = result.get();
        }
        else {
            // we didn't find the station
            throw new RuntimeException("Did not find station id - " + id);
        }

        return station;
    }

    @Override
    public void save(Station station) {
        stationRepository.save(station);
    }

    @Override
    public void deleteById(int id) {
        stationRepository.deleteById(id);
    }
}
