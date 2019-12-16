package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

/**
 * The LannisterActivity contains a two-columned list of House Lannister
 * members, each member has is name and an image
 *
 * The list of names is saved in a private variable called lann_names
 * The list of image ids is saved in a private variable called lann_image_ids
 *
 * Uses the Grid Layout from RecyclerView
 */


public class LannisterActivity extends AppCompatActivity {

    private final String[] lann_names = {"Tywin",
            "Cersei",
            "Jaime",
            "Tyrion",
            "Joffrey",
            "Tommen",
            "Myrcella",
            "Kevan"};


    private final int lann_image_ids[] = {R.drawable.tywinlannister,
            R.drawable.cerseilannister,
            R.drawable.jaimelannister,
            R.drawable.tyrionlannister,
            R.drawable.joffreybaratheon,
            R.drawable.tommen,
            R.drawable.myrcella,
            R.drawable.kavvven
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_lannister);
        initViews();

    }

    /**
     * Initializes the Grid Layout using RecyclerView
     * Initializes an ArrayList called lannHouse using prepareList
     * Sets the list adapter
     */
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> lannHouse = prepareList();
        ListAdapter adapter = new ListAdapter(lannHouse, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    /**
     * Sets the data in a list
     * @return an ArrayList containing a Person object for each family member
     */
    private ArrayList<Person> prepareList(){
        ArrayList<Person> lannister = new ArrayList<>();
        for (int i = 0; i < lann_image_ids.length && i < lann_names.length; i++){
            Person familyMember =  new Person();
            familyMember.setImageId(lann_image_ids[i]);
            familyMember.setName(lann_names[i]);
            lannister.add(familyMember);
        }
        return lannister;
    }

}


