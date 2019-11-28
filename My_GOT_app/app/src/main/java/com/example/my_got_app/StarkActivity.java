package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class StarkActivity extends AppCompatActivity {
    private static final String TAG = "Stark activity";

    private final String stark_names[] = {"Sansa",
            "Arya",
            "Bran",
            "Eddard",
            "Robb",
            "Catelyn",
            "Rickon",
            "Benjen",
            "Lyanna"
    };


    private final int stark_image_ids[] = {R.drawable.sansa,
            R.drawable.arya,
            R.drawable.bran,
            R.drawable.edd,
            R.drawable.robb,
            R.drawable.catelyn,
            R.drawable.rickon,
            R.drawable.benjen,
            R.drawable.lyanna
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG,"On Create" );
        initViews();
    }

    /**
     *
     */
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> starkHouse = prepareData();
        ListAdapter adapter = new ListAdapter(starkHouse, getApplicationContext());
        recyclerView.setAdapter(adapter);
        Log.d(TAG,"init views" );
    }

    private ArrayList<Person> prepareData(){
        ArrayList<Person> starks = new ArrayList<>();
        for (int i = 0; i < stark_names.length && i < stark_image_ids.length; i++){
            Person familyMember =  new Person();
            familyMember.setImageId(stark_image_ids[i]);
            familyMember.setName(stark_names[i]);
            starks.add(familyMember);
        }
        Log.d(TAG,"data is prepared" );
        return starks;
    }
}
