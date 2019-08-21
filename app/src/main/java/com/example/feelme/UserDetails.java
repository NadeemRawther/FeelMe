package com.example.feelme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDetails {

    String phonefather,phoneaunt,phoneuncle,phonegrandfather,phonegrandmother,phonebrother,phonesister,phonemother,name,password;

    public UserDetails(String phonefather, String phoneaunt, String phoneuncle, String phonegrandfather, String phonegrandmother, String phonebrother, String phonesister, String phonemother, String name, String password) {
        this.phonefather = phonefather;
        this.phoneaunt = phoneaunt;
        this.phoneuncle = phoneuncle;
        this.phonegrandfather = phonegrandfather;
        this.phonegrandmother = phonegrandmother;
        this.phonebrother = phonebrother;
        this.phonesister = phonesister;
        this.phonemother = phonemother;
        this.name = name;
        this.password = password;
    }

    public String getPhonefather() {
        return phonefather;
    }

    public String getPhoneaunt() {
        return phoneaunt;
    }

    public String getPhoneuncle() {
        return phoneuncle;
    }

    public String getPhonegrandfather() {
        return phonegrandfather;
    }

    public String getPhonegrandmother() {
        return phonegrandmother;
    }

    public String getPhonebrother() {
        return phonebrother;
    }

    public String getPhonesister() {
        return phonesister;
    }

    public String getPhonemother() {
        return phonemother;
    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
