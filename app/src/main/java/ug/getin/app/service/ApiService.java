package ug.getin.app.service;

import java.util.List;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import ug.getin.app.models.Appointment;
import ug.getin.app.models.Girl;
import ug.getin.app.models.User;

/**
 * Created by abdussekalala on 12/31/15.
 */
public interface ApiService {

    @POST("/login/")
    void loginUser(@Body User user, Callback<User> cb);

    @GET("/girls/list/")
    void listGirls(Callback<List<Girl>> cb);

    @POST("/girls/register/")
    void registerGirl(@Body Girl pregnantGirl, Callback<Girl> cb);

    @GET("/vhts/list/")
    void getVhts(Callback<List<User>> cb);

    @GET("/appointments/upcoming/")
    void getUpcomingAppointment(Callback<List<Appointment>> cb);

    @GET("/appointments/missed/")
    void getMissedAppointment(Callback<List<Appointment>> cb);
}

