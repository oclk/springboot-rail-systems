package com.oclk.rest;

import com.oclk.entity.Train;
import com.oclk.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("/all")
    public List<Train> findAll() {
        return trainService.findAll();
    }

    @GetMapping("/id={id}")
    public Train findById(@PathVariable int id) {
        return trainService.findById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Train train){
        train.setId(0);
        trainService.save(train);
        return train.toString() + " added to database!";
    }

    @PostMapping("/update")
    public String update(@RequestBody Train train){
        trainService.save(train);
        return train.toString() + " updated!";
    }

    @DeleteMapping("/delete={id}")
    public String deleteById(@PathVariable int id) {
        trainService.deleteById(id);
        return id + " deleted from database";
    }
}
