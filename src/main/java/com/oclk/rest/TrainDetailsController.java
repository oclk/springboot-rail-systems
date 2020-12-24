package com.oclk.rest;

import com.oclk.entity.TrainDetails;
import com.oclk.service.TrainDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-details")
public class TrainDetailsController {
    @Autowired
    private TrainDetailsService trainDetailsService;

    @GetMapping("/all")
    public List<TrainDetails> findAll() {
        return trainDetailsService.findAll();
    }

    @GetMapping("/id={id}")
    public TrainDetails findById(@PathVariable int id) {
        return trainDetailsService.findById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody TrainDetails trainDetails){
        trainDetails.setId(0);
        trainDetailsService.save(trainDetails);
        return trainDetails.toString() + " added to database!";
    }

    @PostMapping("/update")
    public String update(@RequestBody TrainDetails trainDetails){
        trainDetailsService.save(trainDetails);
        return trainDetails.toString() + " updated!";
    }

    @DeleteMapping("/delete={id}")
    public String deleteById(@PathVariable int id) {
        trainDetailsService.deleteById(id);
        return id + " deleted from database";
    }

    @GetMapping("/direction={directionId}&station={stationId}")
    public List<TrainDetails> findByDirectionAndStation(@PathVariable int directionId, @PathVariable int stationId) {
        return trainDetailsService.findByDirectionAndStation(directionId, stationId);
    }
}
