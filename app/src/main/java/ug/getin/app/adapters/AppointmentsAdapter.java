package ug.getin.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ug.getin.app.R;
import ug.getin.app.models.Appointment;
import ug.getin.app.models.Girl;

/**
 * Created by abdussekalala on 12/31/15.
 */
public class AppointmentsAdapter extends ArrayAdapter<Appointment> {

    List<Appointment> appointments;
    Context context;

    public AppointmentsAdapter(Context context, int resource,List<Appointment> appointments) {
        super(context, resource);
        this.appointments = appointments;
        this.context = context;


    }

    @Override
    public int getCount() {
        return appointments.size();
    }


    @Override
    public Appointment getItem(int position) {

        return appointments.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.girl_list_item, null);
        }
        Appointment appointment = appointments.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView dob = (TextView) convertView.findViewById(R.id.age);
        TextView marital_status = (TextView) convertView.findViewById(R.id.marital_status);
        TextView education_level = (TextView) convertView.findViewById(R.id.education_level);

        name.setText(appointment.getGirl().getName());

        dob.setText("Date: " + appointment.getDate());




        return convertView;
    }
}
