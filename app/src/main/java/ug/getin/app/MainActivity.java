package ug.getin.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ug.getin.app.adapters.GirlsListAdapter;
import ug.getin.app.models.Girl;
import ug.getin.app.service.ApiClient;
import ug.getin.app.service.ApiService;
import ug.getin.app.ui.MappedGirlsActivity;
import ug.getin.app.ui.MappingActivity;
import ug.getin.app.ui.UpcomingAppointmentsActivity;
import ug.getin.app.ui.VhtsActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Context context = this;
    ListView main_menu;
    String[] main_menu_options = {"Add New Girl", "View Mapped", "Upcomming Appointments", "Missed Appointments", "VHTS"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        main_menu = (ListView) findViewById(R.id.main_menu);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, main_menu_options);
        main_menu.setAdapter(adapter);
        main_menu.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                startActivity(new Intent(context, MappingActivity.class));
                break;
            case 1:
                startActivity(new Intent(context, MappedGirlsActivity.class));
            case 2:
                startActivity(new Intent(context, UpcomingAppointmentsActivity.class));
            case 4:
                startActivity(new Intent(context, VhtsActivity.class));
        }

    }
}
