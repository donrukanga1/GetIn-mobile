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
import ug.getin.app.adapters.GirlsListAdapter;
import ug.getin.app.adapters.VhtsAdapter;
import ug.getin.app.models.Girl;
import ug.getin.app.models.User;
import ug.getin.app.service.ApiClient;
import ug.getin.app.service.ApiService;

public class VhtsActivity extends AppCompatActivity {
    Context context = this;
    ListView vhts_list;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");


        vhts_list = (ListView) findViewById(R.id.vhts_list);


        RestAdapter client = new ApiClient().getRestAdapter();
        ApiService service = client.create(ApiService.class);

        progressDialog.show();

        service.getVhts(new Callback<List<User>>() {
            @Override
            public void success(List<User> vhts, Response response) {
                progressDialog.dismiss();
                vhts_list.setAdapter(new VhtsAdapter(context, R.layout.girl_list_item, vhts));
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });

    }

}
