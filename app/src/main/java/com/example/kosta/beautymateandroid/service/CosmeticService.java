package com.example.kosta.beautymateandroid.service;


import com.example.kosta.beautymateandroid.domain.Cosmetic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by kosta on 2017-06-12.
 */

public interface CosmeticService {


    @GET("cosmetic/findAll")
    Call<List<Cosmetic>> listcosmetic();

    @GET("cosmetic/findByCategory/{cosmeticCategory}")
    Call<List<Cosmetic>> category(@Path("cosmeticCategory") String category);

    @GET("cosmetic/findByNo/{cosmeticNo}")
    Call<Cosmetic>detail(@Path("cosmeticNo") int cosmeticNo);
}
