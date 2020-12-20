package com.example.hike.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "hike")
public class Hike {

    @Id
    private String hikeId;

    private String name;
    private String date;
    private int duration;
    private int complexity; //0-6
    private int min_age;
    private int max_people;
    private double price;

    private String instructorId;


    public Hike(String id, String name, String date, int duration, int complexity, int min_age, int max_people,
                double price, String instructorId){
        this.hikeId = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
        this.instructorId = instructorId;
    }
}

