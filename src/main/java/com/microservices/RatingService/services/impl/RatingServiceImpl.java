package com.microservices.RatingService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.exception.NoRecordFoundException;
import com.microservices.RatingService.repositories.RatingRepository;
import com.microservices.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String userId) {
        return ratingRepository.findByHotelId(userId);
    }

    @Override
    public Rating getRating(String ratingId) throws NoRecordFoundException {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new NoRecordFoundException());
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating deleteRating(String id) throws NoRecordFoundException {
        Rating deleted = ratingRepository.findById(id).orElseThrow(() -> new NoRecordFoundException());
        ratingRepository.delete(deleted);
        return deleted;
    }

}
