package ug.getin.app.models;

import java.util.List;

/**
 * Created by abdussekalala on 2/27/16.
 */
public class User {
    int id;
    String username;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String first_name;
    String last_name;
    String phone_number;
    String type;
    String token;

    public List<Girl> getMapped_girls() {
        return mapped_girls;
    }

    public void setMapped_girls(List<Girl> mapped_girls) {
        this.mapped_girls = mapped_girls;
    }

    List<Girl> mapped_girls;
}
