package com.oclk.rest;

import com.oclk.entity.Wagon;
import com.oclk.service.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wagon")
public class WagonController {
    @Autowired
    private WagonService wagonService;

    @GetMapping("/all")
    public List<Wagon> findAll() {
        return wagonService.findAll();
    }

    @GetMapping("/id={id}")
    public Wagon findById(@PathVariable int id) {
        return wagonService.findById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Wagon wagon){
        wagon.setId(0);
        wagonService.save(wagon);
        return wagon.toString() + " added to database!";
    }

    @PostMapping("/update")
    public String update(@RequestBody Wagon wagon){
        wagonService.save(wagon);
        return wagon.toString() + " updated!";
    }

    @DeleteMapping("/delete={id}")
    public String deleteById(@PathVariable int id) {
        wagonService.deleteById(id);
        return id + " deleted from database";
    }
}
