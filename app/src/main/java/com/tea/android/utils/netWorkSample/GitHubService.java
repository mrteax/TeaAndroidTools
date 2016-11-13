package com.tea.android.utils.netWorkSample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by brc on 2016/10/28.
 */

public interface GitHubService {
    @GET("/users/{user}/repos")
    Call<List<GitApi>> listRepos(@Path("user") String user);

    @GET("/users/{username}")
    Call<GitApi> getUser(@Path("username") String username);

    @GET("/group/{id}/users")
    Call<List<GitApi>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("/users/new")
    Call<GitApi> createUser(@Body GitApi api);
}
