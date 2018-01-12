package com.example.mac.groccerystore.data.model.Remote;

import com.example.mac.groccerystore.data.model.local.JsonResponse;

import java.util.List;
import java.util.Observable;

import javax.annotation.Generated;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mac on 1/11/18.
 */


public interface APIService {

    @GET("search")
    rx.Observable<JsonResponse> getPostsList(@Query("query") String query, @Query("format") String format, @Query("apiKey") String APIKEY);
}
