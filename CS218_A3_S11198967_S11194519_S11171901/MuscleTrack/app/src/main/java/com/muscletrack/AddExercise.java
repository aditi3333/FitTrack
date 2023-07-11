package com.muscletrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.muscletrack.ui.home.HomeViewModel;


public class AddExercise extends AppCompatActivity {

    EditText reps_input, exercise_input, sets_input, weight_input;
    Button add_button;
    HomeViewModel homeViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
       homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reps_input = findViewById(R.id.reps);
                weight_input = findViewById(R.id.weight);
                exercise_input = findViewById(R.id.exercise);
                sets_input = findViewById(R.id.sets);

                ExerciseEntity exerciseEntity = new ExerciseEntity();

                exerciseEntity.setSets(Integer.parseInt(sets_input.getText().toString().trim()));
                exerciseEntity.setExercise(exercise_input.getText().toString().trim());
                exerciseEntity.setWeight(weight_input.getText().toString().trim());
                exerciseEntity.setReps(Integer.parseInt(reps_input.getText().toString().trim()));

                Boolean check = validate(reps_input, sets_input, weight_input, exercise_input);
                if(check==true)
                {
                    homeViewModel.addTx(exerciseEntity);
                    Toast.makeText(AddExercise.this, "Exercise added!", Toast.LENGTH_SHORT).show();
                }



        }
        });
    }

    private Boolean validate(EditText repsCheck, EditText setsCheck, EditText weightCheck, EditText exerciseCheck)
    {
        if(exerciseCheck.length() == 0)
        {
            exercise_input.requestFocus();
            exercise_input.setError("Field Cannot be empty");
            return false;
        }
        else
            return true;
    }

}