package com.masai.a1516july_retrofit_ii_we1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // https://jsonplaceholder.typicode.com/comments?postId=2
    @GET("/comments")
    Call<List<ResponseModel>> getPosts(@Query("postId") int postId);
}
