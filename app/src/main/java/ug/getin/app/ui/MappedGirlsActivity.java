package ug.getin.app.ui;

import android.app.ActionBar;
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
import ug.getin.app.models.Girl;
import ug.getin.app.service.ApiClient;
import ug.getin.app.service.ApiService;

public class MappedGirlsActivity extends AppCompatActivity {
    Context context = this;
    ListView girlsListView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapped_girls);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");


        girlsListView = (ListView) findViewById(R.id.girlsListView);

        RestAdapter client = new ApiClient().getRestAdapter();
        ApiService service = client.create(ApiService.class);

        progressDialog.show();

        service.listGirls(new Callback<List<Girl>>() {
            @Override
            public void success(List<Girl> girls, Response response) {
                progressDialog.dismiss();
                girlsListView.setAdapter(new GirlsListAdapter(context, R.layout.girl_list_item, girls));
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });

    }

}
