package com.oclk.service;

import com.oclk.dao.WagonRepository;
import com.oclk.entity.Wagon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WagonServiceImp implements WagonService {
    @Autowired
    private WagonRepository wagonRepository;

    @Override
    public List<Wagon> findAll() {
        return wagonRepository.findAll();
    }

    @Override
    public Wagon findById(int id) {
        Optional<Wagon> result = wagonRepository.findById(id);

        Wagon wagon = null;

        if (result.isPresent()) {
            wagon = result.get();
        }
        else {
            // we didn't find the wagon
            throw new RuntimeException("Did not find wagon id - " + id);
        }

        return wagon;
    }

    @Override
    public void save(Wagon wagon) {
        wagonRepository.save(wagon);
    }

    @Override
    public void deleteById(int id) {
        wagonRepository.deleteById(id);
    }
}
