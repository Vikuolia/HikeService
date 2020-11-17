package com.example.hike.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "hike")
public class Hike {

    @Id
    private UUID hikeId;

    private String name;
    private String date;
    private int duration;
    private int complexity; //0-6
    private int min_age;
    private int max_people;
    private double price;

    private UUID instructorId;


    public Hike(String name, String date, int duration, int complexity, int min_age, int max_people,
                double price, UUID instructorId){
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
        this.instructorId = instructorId;
    }

//    public void changeInstructor(Instructor instructor){
//        this.instructor = instructor;
//    }
//
//    public double getPrice(){return this.price;}
//
//    public int getComplexity(){return this.complexity;}
//
//    public int getMin_age(){return this.min_age;}
//
//    public int getMax_people(){return  this.max_people;}
//
//    public String getName(){return this.name;}
}

