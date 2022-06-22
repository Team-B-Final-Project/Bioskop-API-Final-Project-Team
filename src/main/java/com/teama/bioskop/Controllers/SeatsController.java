package com.teama.bioskop.Controllers;

import com.teama.bioskop.Models.Seats;
import com.teama.bioskop.Services.SeatsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class SeatsController {
    private final SeatsService seatsService;

    @GetMapping("/seats")
    public List<Seats> getAll() {
        return this.seatsService.getAllSeats();

    }

    @GetMapping("/seats/{id}")
    public Optional<Seats> CreateSeats(@PathVariable("seats") Integer seats) {
        return this.seatsService.CreateSeats(seats);
    }

    @PostMapping("/seats")
    public Seats InsertSeats(@RequestBody Seats seats) {
        seatsService.insertNewSeats(seats);
        return seats;
    }

    @PutMapping("/seats")
    public Seats UpdateSeats(@RequestBody Seats seats) {
        seatsService.UpdateSeats(seats.getSeatId());
        return seats;


    }

    @DeleteMapping("/seats/{id}")
    public ResponseEntity<Optional<Seats>> deleteSeath(@PathVariable("seats") Integer seath) {
        Optional<Seats> deletedSeats = seatsService.getSeatsById(seath);
        seatsService.deleteSeath(seath);
        return ResponseEntity.status(HttpStatus.OK).body(deletedSeats);

    }
}