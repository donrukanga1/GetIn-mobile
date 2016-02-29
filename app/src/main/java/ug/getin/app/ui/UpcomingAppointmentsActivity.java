package ug.getin.app.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ug.getin.app.R;
import ug.getin.app.adapters.AppointmentsAdapter;
import ug.getin.app.adapters.GirlsListAdapter;
import ug.getin.app.models.Appointment;
import ug.getin.app.models.Girl;
import ug.getin.app.service.ApiClient;
import ug.getin.app.service.ApiService;

public class UpcomingAppointmentsActivity extends AppCompatActivity {
    Context context = this;
    ProgressDialog progressDialog;
    ListView upcoming_appointments_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_appointments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upcoming_appointments_list = (ListView) findViewById(R.id.upcoming_appointments);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");

        RestAdapter client = new ApiClient().getRestAdapter();
        ApiService service = client.create(ApiService.class);

        progressDialog.show();

        service.getUpcomingAppointment(new Callback<List<Appointment>>() {
            @Override
            public void success(List<Appointment> appointments, Response response) {
                progressDialog.dismiss();
                upcoming_appointments_list.setAdapter(new AppointmentsAdapter(context, R.layout.girl_list_item, appointments));
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });

    }

}
