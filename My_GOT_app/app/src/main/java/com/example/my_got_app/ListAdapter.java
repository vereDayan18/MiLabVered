package com.example.my_got_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This class implements the RecyclerView adapter
 * Initializes the ViewHolder
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        ArrayList<Person> list;
        Context context;


        public ListAdapter(ArrayList<Person> list, Context context) {
                this.context = context;
                this.list = list;

        }

        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_menu, viewGroup, false);
                return new ViewHolder(view);
        }

        public void onBindViewHolder(ListAdapter.ViewHolder viewHolder, int i){
                viewHolder.text.setText(list.get(i).getName());
                viewHolder.imageId.setImageResource(list.get(i).getImageId());
        }

        public int getItemCount(){
                return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
                private TextView text;
                private ImageView imageId;

                public ViewHolder(View view){
                        super(view);
                        text = (TextView)view.findViewById(R.id.mTextView);
                        imageId = (ImageView)view.findViewById(R.id.mImageView);

                }
        }
}