package com.aravind.gosh.kitkorner;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        final ToggleButton button = (ToggleButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.isChecked()) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                    Toast.makeText(chronometer.getContext(), "Started", Toast.LENGTH_SHORT).show();
                } else {
                    chronometer.stop();
                    Toast.makeText(chronometer.getContext(), "Stopped", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
