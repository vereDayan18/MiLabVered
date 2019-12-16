package com.example.poohquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * The MainActivity implements an application that
 * displays a button
 *
 * Clicking on the button starts a
 * notificationService intent service
 *
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Activity has been launched!");

        Button quoteButton = (Button)findViewById(R.id.button);
        quoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationService.startAction(MainActivity.this);
            }

        });

    }
}
