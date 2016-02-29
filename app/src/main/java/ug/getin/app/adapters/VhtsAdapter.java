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
import ug.getin.app.models.User;

/**
 * Created by abdussekalala on 12/31/15.
 */
public class VhtsAdapter extends ArrayAdapter<User> {

    List<User> vhts;
    Context context;

    public VhtsAdapter(Context context, int resource,List<User> vhts) {
        super(context, resource);
        this.vhts = vhts;
        this.context = context;


    }

    @Override
    public int getCount() {
        return vhts.size();
    }


    @Override
    public User getItem(int position) {

        return vhts.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.girl_list_item, null);
        }
        User vht = vhts.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView dob = (TextView) convertView.findViewById(R.id.age);
        TextView marital_status = (TextView) convertView.findViewById(R.id.marital_status);
        TextView education_level = (TextView) convertView.findViewById(R.id.education_level);

        name.setText(vht.getFirst_name() + " " + vht.getLast_name());

        dob.setText("Mapped girls: " + vht.getMapped_girls().size());




        return convertView;
    }
}
