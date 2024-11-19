package com.microservices.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.exception.NoRecordFoundException;
import com.microservices.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    //create the user
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId) throws NoRecordFoundException {
        Rating rating = ratingService.getRating(ratingId);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @GetMapping("byUser/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) throws NoRecordFoundException {
        List<Rating> ratings = ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
    }

    @GetMapping("byHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) throws NoRecordFoundException {
        List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getRatings() {
        List<Rating> ratings = ratingService.getRatings();
        return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
    }

    @PutMapping()
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        Rating updated = ratingService.updateRating(rating);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{uuId}")
    public ResponseEntity<Rating> deleteRating(@PathVariable String uuId) throws NoRecordFoundException {
        Rating deleted = ratingService.deleteRating(uuId);
        return ResponseEntity.ok(deleted);
    }
}
