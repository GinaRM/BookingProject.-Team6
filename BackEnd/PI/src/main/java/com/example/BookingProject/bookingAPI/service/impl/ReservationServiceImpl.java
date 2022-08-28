package com.example.BookingProject.bookingAPI.service.impl;

import com.example.BookingProject.bookingAPI.exception.ResourceNotFoundException;
import com.example.BookingProject.bookingAPI.persistence.model.Image;
import com.example.BookingProject.bookingAPI.persistence.model.Reservation;
import com.example.BookingProject.bookingAPI.persistence.repository.ReservationRepository;
import com.example.BookingProject.bookingAPI.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> createManyReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation getReservationById(Long id) {
        if(reservationRepository.existsById(id)){
            Reservation reservation = reservationRepository.findById(id).get();
            return reservation;
        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public String deleteReservation(Long id) {
        if(reservationRepository.findById(id).isPresent()){
            reservationRepository.deleteById(id);
            return "Reservation with id: " + id + " has been successfully deleted";
        } else
            throw new ResourceNotFoundException("Reservation with id: " + id + " doesn't exist");
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {

        Optional<Reservation> reservOptional = this.reservationRepository.findById(reservation.getId());
        if (reservOptional.isPresent()) {
            Reservation existingReservation = reservOptional.get();
            existingReservation.setId(reservation.getId());
            existingReservation.setCheckIn_hour(reservation.getCheckIn_hour());
            existingReservation.setCheckIn(reservation.getCheckIn());
            existingReservation.setCheckOut(reservation.getCheckOut());
            return reservationRepository.save(existingReservation);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + reservation.getId());
        }
    }
}