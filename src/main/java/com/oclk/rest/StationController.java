package com.oclk.rest;

import com.oclk.entity.Station;
import com.oclk.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/all")
    public List<Station> findAll() {
        return stationService.findAll();
    }

    @GetMapping("/id={id}")
    public Station findById(@PathVariable int id) {
        return stationService.findById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Station station){
        station.setId(0);
        stationService.save(station);
        return station.toString() + " added to database!";
    }

    @PostMapping("/update")
    public String update(@RequestBody Station station){
        stationService.save(station);
        return station.toString() + " updated!";
    }

    @DeleteMapping("/delete={id}")
    public String deleteById(@PathVariable int id) {
        stationService.deleteById(id);
        return id + " deleted from database";
    }
}
