package com.muscletrack.ui.home;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.muscletrack.ExerciseEntity;
import com.muscletrack.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private List<ExerciseEntity> exerciseList = new ArrayList<>();
    private ItemClicked itemClicked;


    public HomeAdapter(ItemClicked itemClicked)
    {
        this.itemClicked = itemClicked;
    }
    public HomeAdapter(){

    }
    public void setData(List<ExerciseEntity> exerciseList) {
        this.exerciseList = exerciseList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView exerciseView;
        TextView weightView;
        TextView setsView;
        TextView repsView;
        CardView workoutView;
        ImageView options;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseView = itemView.findViewById(R.id.lblExercise);
            weightView = itemView.findViewById(R.id.lblWeight);
            setsView = itemView.findViewById(R.id.lblSets);
            repsView = itemView.findViewById(R.id.lblReps);
            workoutView = itemView.findViewById(R.id.Workout_view);
            options = itemView.findViewById(R.id.menuOption);

        }
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        ExerciseEntity exerciseEntity = exerciseList.get(position);
        String exercise = exerciseEntity.getExercise();
        String weight = exerciseEntity.getWeight();
        String sets = String.valueOf(exerciseEntity.getSets());
        String reps = String.valueOf(exerciseEntity.getReps());

        holder.exerciseView.setText(exercise);
        holder.weightView.setText(weight);
        holder.setsView.setText(sets);
        holder.repsView.setText(reps);

        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showPopup(view, exerciseEntity);
            }
        });

    }

    public void showPopup(View view, final ExerciseEntity exerciseEntity)
    {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.inflate(R.menu.menu_options);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id)
                {
                    case R.id.deleteOption:
                        itemClicked.deleteClicked(exerciseEntity);
                        Toast.makeText(view.getContext(), "Delete exercise", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.updateOption:
                        itemClicked.updateClicked(exerciseEntity);
                        Toast.makeText(view.getContext(), "Update exercise", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public interface ItemClicked
    {
        void updateClicked(ExerciseEntity exerciseEntity);
        void deleteClicked(ExerciseEntity exerciseEntity);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
