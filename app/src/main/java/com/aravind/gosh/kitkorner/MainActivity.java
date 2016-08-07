package com.aravind.gosh.kitkorner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPSTracker track = new GPSTracker(this);
        if(!track.canGetLocation()) {
            Toast.makeText(this, "Cannot get location", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, track.getLatitude() + "\n" + track.getLongitude(), Toast.LENGTH_SHORT);
        }
    }


}
