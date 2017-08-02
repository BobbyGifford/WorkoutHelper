package com.example.bobby.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCustomExercise extends AppCompatActivity {
//    private static ArrayList<ExerciseLists> newDefaultList = new ArrayList<ExerciseLists>() {{
//        add(new ExerciseLists("strength"));
//        add(new ExerciseLists("cardio"));
//    }};

    private String newExerciseName;
    private String newExerciseDesc;
    private int exerciseCategory = DefaultList.getExerciseCategory();

    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_exercise);
        dbHandler = new DatabaseHandler(this, null, null, 1);

    }

    public void onCreateNewExercise(View view) {
        EditText newExerciseName = (EditText) findViewById(R.id.customExerciseNameInput);
        EditText newExerciseDesc = (EditText) findViewById(R.id.customExerciseDescInput);

        this.newExerciseName = newExerciseName.getText().toString();
        this.newExerciseDesc = newExerciseDesc.getText().toString();

        DefaultList.getDefaultList().get(exerciseCategory).getTestList()
                .add(new Exercises(this.newExerciseName, this.newExerciseDesc, true));

        dbHandler.addExercise(this.exerciseCategory, this.newExerciseName, this.newExerciseDesc);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
