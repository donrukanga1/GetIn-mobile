package ug.getin.app.models;

/**
 * Created by abdussekalala on 2/28/16.
 */
public class Appointment {
    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    Girl girl;
    String date;
}
