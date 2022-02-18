package edu.cascadia.mobile.apps.passwordcheck;
// Adapted from https://www.bignerdranch.com/blog/two-way-data-binding-on-android-observing-your-view-with-xml/



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PasswordViewModel extends ViewModel {
    private MutableLiveData<String> password;
    private LiveData<String> passwordQuality;


    private MutableLiveData<String> getPassword() {
        return password;
    }


    private LiveData<String> getPasswordQuality() {
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
            notifyPropertyChanged(passwordQuality);
            notifyPropertyChanged(password);
        }
    }


}
