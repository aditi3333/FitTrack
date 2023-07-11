package com.muscletrack;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Exercise_Table")
public class ExerciseEntity{

    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "Exercise")
    private String Exercise;

    @ColumnInfo(name = "Weight")
    private String Weight;

    @ColumnInfo(name = "Sets")
    private int Sets;

    @ColumnInfo(name = "Reps")
    private int Reps;

    ExerciseEntity(int id, String exercise, String weight, int sets, int reps) {
        Id = id;
        Exercise = exercise;
        Weight = weight;
        Sets = sets;
        Reps = reps;
    }


    ExerciseEntity(String exercise, String weight, int sets, int reps) {
        Exercise = exercise;
        Weight = weight;
        Sets = sets;
        Reps = reps;
    }



    ExerciseEntity(){

    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getExercise() {
        return Exercise;
    }

    public void setExercise(String exercise) {
        Exercise = exercise;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public int getSets() {
        return Sets;
    }

    public void setSets(int sets) {
        Sets = sets;
    }

    public int getReps() {
        return Reps;
    }

    public void setReps(int reps) {
        Reps = reps;
    }


}
