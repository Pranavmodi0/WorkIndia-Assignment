package com.example.railway_management.service;

import com.example.railway_management.model.Booking;
import com.example.railway_management.model.Train;
import com.example.railway_management.repository.BookingRepository;
import com.example.railway_management.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getTrainsBySourceAndDestination(String source, String destination) {
        return trainRepository.findAll().stream()
                .filter(train -> train.getSource().equalsIgnoreCase(source) &&
                        train.getDestination().equalsIgnoreCase(destination))
                .toList();
    }

    public String bookSeat(Long trainId, int numberOfSeats, String userId) {
        Train train = trainRepository.findById(trainId).orElse(null);
        if (train != null && train.getAvailableSeats() >= numberOfSeats) {
            train.setAvailableSeats(train.getAvailableSeats() - numberOfSeats);
            trainRepository.save(train);

            Booking booking = new Booking();
            booking.setTrain(train);
            booking.setUserId(userId);
            booking.setNumberOfSeats(numberOfSeats);
            booking.setBookingTime(LocalDateTime.now());
            bookingRepository.save(booking);

            return "Booking successful!";
        }
        return "Insufficient seats available!";
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }
}
