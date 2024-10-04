package com.example.railway_management.controller;

import com.example.railway_management.model.Booking;
import com.example.railway_management.model.Train;
import com.example.railway_management.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train createdTrain = trainService.addTrain(train);
        return ResponseEntity.ok(createdTrain);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Train>> getSeatAvailability(@RequestParam String source,
                                                           @RequestParam String destination) {
        List<Train> availableTrains = trainService.getTrainsBySourceAndDestination(source, destination);
        return ResponseEntity.ok(availableTrains);
    }

    @PreAuthorize("hasRole('user')")
    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(@RequestParam Long trainId,
                                           @RequestParam int numberOfSeats,
                                           @RequestParam String userId) {
        String response = trainService.bookSeat(trainId, numberOfSeats, userId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getUserBookings(@RequestParam String userId) {
        List<Booking> bookings = trainService.getBookingsByUserId(userId);
        return ResponseEntity.ok(bookings);
    }
}
