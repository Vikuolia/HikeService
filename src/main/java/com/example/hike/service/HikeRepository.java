package com.example.hike.service;

import com.example.hike.model.Hike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HikeRepository extends JpaRepository<Hike, String> {
}
