package com.muscletrack.ui.motivation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muscletrack.R;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {


    Context context;
    int[] images;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView rowImage;
        // Create a constructor that accepts the entire row and search the View hierarchy to find each subview
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowImage = itemView.findViewById(R.id.image_view);
        }
    }
    // Provide a suitable constructor
    public ProgramAdapter(Context context, int[] images){
        this.context = context;
        this.images = images;
    }

    // Create new views to be invoked by the layout manager
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a LayoutInflater object
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View view = inflater.inflate(R.layout.list_item_motivation, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view to be invoked by the layout manager
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the contents of the View with that element
        holder.rowImage.setImageResource(images[position]);
    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return images.length;
    }
}