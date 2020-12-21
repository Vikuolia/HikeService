package com.example.hike.api;

import com.example.hike.*;
import com.example.hike.model.Hike;
import com.example.hike.service.HikeService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class GrpcHikeController extends HikeServiceGrpc.HikeServiceImplBase {

    @Autowired
    private HikeService hikeService;

    @Override
    public void add(HikeRequest request, StreamObserver<HikeResponse> responseObserver) {
        String name = request.getName();
        String date = request.getDate();
        int duration = request.getDuration();
        int complexity = request.getComplexity();
        int minAge = request.getMinAge();
        int maxPeople = request.getMaxPeople();
        double price = request.getPrice();
        String instructor = request.getInstructorId();

        Hike hikeAdd = new Hike(name, date, duration, complexity, minAge, maxPeople, price, instructor);
        Hike hikeResponse = hikeService.addHike(hikeAdd);

        HikeResponse response = HikeResponse.newBuilder()
                                            .setHikeId(hikeResponse.getHikeId())
                                            .setName(hikeResponse.getName())
                                            .setDate(hikeResponse.getDate())
                                            .setDuration(hikeResponse.getDuration())
                                            .setComplexity(hikeResponse.getComplexity())
                                            .setMinAge(hikeResponse.getMin_age())
                                            .setMaxPeople(hikeResponse.getMax_people())
                                            .setPrice(hikeResponse.getPrice())
                                            .setInstructorId(hikeResponse.getInstructorId())
                                            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllHikesRequest request, StreamObserver<AllHikesResponse> responseObserver) {
        List<Hike> hikes = hikeService.getAll();
        List<HikeResponse> responses = new ArrayList<>();

        for(Hike hike: hikes){
            HikeResponse oneResponse = HikeResponse.newBuilder()
                                                    .setHikeId(hike.getHikeId())
                                                    .setName(hike.getName())
                                                    .setDate(hike.getDate())
                                                    .setDuration(hike.getDuration())
                                                    .setComplexity(hike.getComplexity())
                                                    .setMinAge(hike.getMin_age())
                                                    .setMaxPeople(hike.getMax_people())
                                                    .setPrice(hike.getPrice())
                                                    .setInstructorId(hike.getInstructorId())
                                                    .build();

            responses.add(oneResponse);
        }

        AllHikesResponse response = AllHikesResponse.newBuilder().addAllHikes(responses).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(HikeByIdRequest request, StreamObserver<HikeResponse> responseObserver) {
        Hike hike = hikeService.getById(request.getId());

        HikeResponse response = HikeResponse.newBuilder()
                                            .setHikeId(hike.getHikeId())
                                            .setName(hike.getName())
                                            .setDate(hike.getDate())
                                            .setDuration(hike.getDuration())
                                            .setComplexity(hike.getComplexity())
                                            .setMinAge(hike.getMin_age())
                                            .setMaxPeople(hike.getMax_people())
                                            .setPrice(hike.getPrice())
                                            .setInstructorId(hike.getInstructorId())
                                            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(HikeByIdRequest request, StreamObserver<DeleteHikeResponse> responseObserver) {
        hikeService.deleteById(request.getId());
        DeleteHikeResponse response = DeleteHikeResponse.newBuilder()
                .setResponse("Hike with id " + request.getId() + " was deleted")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
