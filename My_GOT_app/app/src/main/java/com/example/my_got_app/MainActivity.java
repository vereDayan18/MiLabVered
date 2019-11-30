package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * The MainActivity implements an application that
 * displays two flags, each has a button related -
 * one for House Lannister and one for House Stark
 *
 * Clicking on House Stark leads to StarkActivity
 * Clicking on House Lannister leads to LannisterActivity
 *
 * Starts playing the background music that follows
 * all activities in app
 */

public class MainActivity extends AppCompatActivity {


        private static final String TAG = "MainActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Log.d(TAG,"On Create" );

            /*
            Setting the two buttons and their onClickListener
             */
            Button starkButton = (Button)findViewById(R.id.starkButton);
            starkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Info log","Stark Button Clicked" );
                    Intent intent = new Intent(view.getContext(), StarkActivity.class);
                    startActivity(intent);
                }
            });

            Button lannisterButton = (Button)findViewById(R.id.lannisterButton);
            lannisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Info log","Lannister Button Clicked" );
                    Intent intent = new Intent(view.getContext(), LannisterActivity.class);
                    startActivity(intent);
                }
            });

            /*
            Starts the background music using a service
            from BackGroundMusic class
             */
            Intent music = new Intent(this, BackgroundMusic.class);
            music.setAction("com.example.my_got_app.BackgroundMusic");
            startService(music);

        }


}