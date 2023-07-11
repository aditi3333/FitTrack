package com.muscletrack.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.muscletrack.ExerciseEntity;
import com.muscletrack.ExerciseRepo;

import java.util.List;

public class HomeViewModel extends AndroidViewModel{

    ExerciseRepo exerciseRepo;
    LiveData<List<ExerciseEntity>> exerciseEntities;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        exerciseRepo = new ExerciseRepo(application);
        exerciseEntities = exerciseRepo.getAllExercise();
    }

    public LiveData<List<ExerciseEntity>> getAllExercise() {
        return exerciseRepo.getAllExercise();
    }

    public void addTx(ExerciseEntity exerciseEntity) {
        exerciseRepo.addTx(exerciseEntity);
    }
    public void updateTx(ExerciseEntity exerciseEntity)
    {
        exerciseRepo.updateTx(exerciseEntity);
    }
    public void deleteTx(ExerciseEntity exerciseEntity)
    {
        exerciseRepo.deleteTx(exerciseEntity);
    }

}
