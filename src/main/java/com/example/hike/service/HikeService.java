package com.example.hike.service;

import com.example.hike.model.Hike;
import javassist.NotFoundException;

import java.util.List;

public interface HikeService {

    Hike addHike(Hike newHike);

    List<Hike> getAll();

    Hike getById(String id);

    void deleteById(String id);

}
