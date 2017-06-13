package com.example.kosta.beautymateandroid.service;


import com.example.kosta.beautymateandroid.domain.Review;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kosta on 2017-06-12.
 */

public interface ReviewService {

    @GET("review/list")
    Call<List<Review>> listReview();

}
