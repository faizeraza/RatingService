package com.microservices.RatingService.services;

import java.util.List;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.exception.NoRecordFoundException;

public interface RatingService {

    //create rating
    public Rating createRating(Rating rating);

    //update rating
    public Rating updateRating(Rating rating);

    // get Rating by id
    public Rating getRating(String ratingId) throws NoRecordFoundException;

    // get Rating by userid
    public List<Rating> getRatingByUserId(String userId) throws NoRecordFoundException;

    // get Rating by hotelid
    public List<Rating> getRatingByHotelId(String hotelId) throws NoRecordFoundException;

    // get Ratings
    public List<Rating> getRatings();

    //delete Rating by id
    public Rating deleteRating(String id) throws NoRecordFoundException;
}
