package com.example.hike.service;

import com.example.hike.model.Hike;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HikeServiceImpl implements HikeService {

    private final HikeRepository hikeRepository;

    @Autowired
    public HikeServiceImpl(HikeRepository hikeRepository) {
        this.hikeRepository = hikeRepository;
    }

    @Override
    public Hike addHike(Hike newHike) {
        return hikeRepository.save(newHike);
    }

    @Override
    public List<Hike> getAll() {
        return (List<Hike>)hikeRepository.findAll();
    }

    @Override
    public Hike getById(String id) throws NotFoundException {
        Optional<Hike> optionalHike = hikeRepository.findById(id);
        if(optionalHike.isPresent()) return hikeRepository.findById(id).get();
        else throw new NotFoundException(String.format("Hike with id: %s does not exist", id));
    }

    @Override
    public void deleteById(String id) {
        hikeRepository.deleteById(id);
    }

}

