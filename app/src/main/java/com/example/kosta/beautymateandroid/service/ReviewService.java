package com.example.kosta.beautymateandroid.service;


import com.example.kosta.beautymateandroid.domain.Review;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by kosta on 2017-06-12.
 */

public interface ReviewService {

    @GET("review/list")
    Call<List<Review>> listReview();

    @POST("review/register")
    Call<Review> reviewRegister(@Body Review review);

    @POST("review/remove/reviewNo/{reviewNo}")
    Call<Integer> reviewRemove(@Path("reviewNo")int reviewNo);

    @POST("review/modify")
    Call<Void> reviewModify(@Body Review review);

}
