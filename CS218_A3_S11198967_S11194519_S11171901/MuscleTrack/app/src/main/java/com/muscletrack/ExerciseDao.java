package com.muscletrack;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Query("select * from Exercise_Table")
    LiveData<List<ExerciseEntity>> getAllExercise();

    @Insert
    void addTx(ExerciseEntity exerciseEntity);
    @Update
    void updateTx(ExerciseEntity exerciseEntity);
    @Delete
    void deleteTx(ExerciseEntity exerciseEntity);
    @Query("DELETE FROM Exercise_Table")
    void deleteAllExercise();

}
