package com.example.mac.groccerystore.data.model.Remote;

import com.example.mac.groccerystore.data.model.local.Post;

import java.util.List;
import java.util.Observable;

import javax.annotation.Generated;

import retrofit2.http.GET;

/**
 * Created by mac on 1/11/18.
 */

public interface APIService {
    @GET("/posts")
    rx.Observable<List<Post>> getPostsList();
}
