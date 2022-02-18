package edu.cascadia.mobile.apps.passwordcheck;
// Adapted from https://www.bignerdranch.com/blog/two-way-data-binding-on-android-observing-your-view-with-xml/
import androidx.databinding.BaseObservable;


import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PasswordViewModel extends ViewModel {
    private String password;


    @Bindable
    public String getPassword() {
        return password;
    }

    @Bindable
    public String getPasswordQuality() {
        if (password == null || password.isEmpty()) {
            return "Enter a password";
        } else if (password.equals("password")) {
            return "Very bad";
        } else if (password.length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }
    }

    public void setPassword(String password) {
        if(!this.password.equals(password)) {
            this.password = password;
            notifyPropertyChanged(BR.passwordQuality);
            notifyPropertyChanged(BR.password);
        }
    }


}
