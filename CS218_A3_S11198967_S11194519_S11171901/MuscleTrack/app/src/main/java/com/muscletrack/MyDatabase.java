package com.muscletrack;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = ExerciseEntity.class, exportSchema = false, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private Context context;
    private static final String DATABASE_NAME = "MuscleTrackdb";

    @SuppressLint("StaticFieldLeak")
    private static MyDatabase instance;
    public abstract ExerciseDao exerciseDao();

    public static synchronized MyDatabase getDB(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder (context, MyDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }

        return instance;
    }


    /*

    private static final String TABLE_NAME = "my_tracker";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_REPS = "num_reps";
    private static final String COLUMN_EXERCISE = "which_exercise";
    private static final String COLUMN_WEIGHT = "what_weight";
    private static final String COLUMN_SETS = "num_sets";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EXERCISE + " TEXT, " +
                COLUMN_WEIGHT + " TEXT, " +
                COLUMN_REPS + " INTEGER, " +
                COLUMN_SETS + " INTEGER);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void add(ExerciseEntity exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_REPS, exercise.getReps());
        cv.put(COLUMN_EXERCISE, exercise.getExercise());
        cv.put(COLUMN_WEIGHT, exercise.getWeight());
        cv.put(COLUMN_SETS, exercise.getSets());
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public List <ExerciseEntity> readAllData() {
        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query, null);
        }

        if(cursor.moveToFirst())
        {
            do{
                ExerciseEntity exerciseEntity = new ExerciseEntity();
                exerciseEntity.setExercise(cursor.getString(0));
                exerciseEntity.setReps(Integer.parseInt(cursor.getString(1)));
                exerciseEntity.setSets(Integer.parseInt(cursor.getString(2)));
                exerciseEntity.setWeight(cursor.getString(3));

            }while(cursor.moveToNext());
        }
        return exerciseEntityList;
    }

     */

}


