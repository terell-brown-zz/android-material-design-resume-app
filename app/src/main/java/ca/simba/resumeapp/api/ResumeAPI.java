package ca.simba.resumeapp.api;

import android.util.Base64;

import java.util.List;

import ca.simba.resumeapp.mypojo.CSRF;
import ca.simba.resumeapp.mypojo.Resume;
import ca.simba.resumeapp.mypojo.User;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by tmast_000 on 9/1/2015.
 */
public interface ResumeAPI {


    @FormUrlEncoded
    @POST("/rest-auth/login/")
    void login(
            @Field("username") String username,
            @Field("password") String password,
            Callback<CSRF> response);


    @GET("/api/v1/{username}/")
     void getUser(
            @Header("Authorization") String auth,
            @Path("username") String username,
            Callback<User> response
    );

    @GET("/api/v1/resume/{resumeName}/")
    public void getResume(
            @Header("Authorization") String auth,
            @Path("resumeName") String resumeName,
            Callback<List<Resume>> response
    );

}
