package com.muscletrack;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExerciseRepo {
    private ExerciseDao exerciseDao;
    private MyDatabase myDatabase;
    private LiveData<List<ExerciseEntity>> exerciseList;

    public ExerciseRepo(Application application) {
        myDatabase = MyDatabase.getDB(application);
        exerciseDao = myDatabase.exerciseDao();
        exerciseList = exerciseDao.getAllExercise();
    }

    public LiveData<List<ExerciseEntity>> getAllExercise() {
        return exerciseDao.getAllExercise();
    }


    public void addTx(final ExerciseEntity exerciseEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDatabase.exerciseDao().addTx(exerciseEntity);
                return null;
            }
        }.execute();
    }

    public void deleteTx(final ExerciseEntity exerciseEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDatabase.exerciseDao().deleteTx(exerciseEntity);
                return null;
            }
        }.execute();
    }

    public void updateTx(final ExerciseEntity exerciseEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDatabase.exerciseDao().updateTx(exerciseEntity);
                return null;
            }
        }.execute();
    }




}
