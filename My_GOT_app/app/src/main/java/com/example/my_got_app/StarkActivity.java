package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


/**
 * The StarkActivity contains a two-columned list of House Stark
 * members, each member has is name and an image
 *
 * The list of names is saved in a private variable called stark_names
 * The list of image ids is saved in a private variable called stark_image_ids
 *
 * Uses the Grid Layout from RecyclerView
 */

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
     * Initializes the Grid Layout using RecyclerView
     * Initializes an ArrayList called starkHouse using prepareList
     * Sets the list adapter
     */
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> starkHouse = prepareList();
        ListAdapter adapter = new ListAdapter(starkHouse, getApplicationContext());
        recyclerView.setAdapter(adapter);
        Log.d(TAG,"init views" );
    }

    /**
     * Sets the data in a list
     * @return an ArrayList containing a Person object for each family member
     */
    private ArrayList<Person> prepareList(){
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
