package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


        private static final String TAG = "MainActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Log.d(TAG,"On Create" );

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

            //background music service
            Intent svc = new Intent(this, BackgroundMusic.class);
            svc.setAction("com.example.my_got_app.BackgroundMusic");
            startService(svc);

        }


}