package com.example.hike.service;

import com.example.hike.model.Hike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HikeServiceImpl implements HikeService {

    private final HikeRepository hikeRepository;

    @Autowired
    public HikeServiceImpl(HikeRepository hikeRepository) {
        this.hikeRepository = hikeRepository;
    }

    @Override
    public Hike addHike(Hike hike) {
        return hikeRepository.save(hike);
    }

    @Override
    public List<Hike> getAll() {
        return (List<Hike>)hikeRepository.findAll();
    }

    @Override
    public Hike getById(String id){
        return hikeRepository.getOne(id);
    }

    @Override
    public void deleteById(String id) {
        hikeRepository.deleteById(id);
    }

}

