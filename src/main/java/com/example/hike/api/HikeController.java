package com.example.hike.api;

import com.example.hike.model.Hike;
import com.example.hike.service.HikeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HikeController {

    private final HikeService hikeService;

    @Autowired
    public HikeController(HikeService hikeService) {
        this.hikeService = hikeService;
    }

    @PostMapping
    public Hike addHike(@RequestBody Hike hike){
        return hikeService.addHike(hike);
    }

    @GetMapping("/all")
    public List<Hike> getAllHikes(){
        return hikeService.getAll();
    }

    @GetMapping("{hikeId}")
    public Hike getHikeById(@PathVariable String hikeId) throws NotFoundException {
        return hikeService.getById(hikeId);
    }

    @DeleteMapping("{hikeId}")
    public ResponseEntity<Void> deleteHikeById(@PathVariable String hikeId){
        hikeService.deleteById(hikeId);
        return ResponseEntity.noContent().build();
    }

}

