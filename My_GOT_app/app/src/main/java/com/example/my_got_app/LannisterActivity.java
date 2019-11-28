package com.example.my_got_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

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

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> starkHouse = prepareData();
        ListAdapter adapter = new ListAdapter(starkHouse, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Person> prepareData(){
        ArrayList<Person> starks = new ArrayList<>();
        for (int i = 0; i < lann_image_ids.length && i < lann_names.length; i++){
            Person familyMember =  new Person();
            familyMember.setImageId(lann_image_ids[i]);
            familyMember.setName(lann_names[i]);
            starks.add(familyMember);
        }
        return starks;
    }

}


