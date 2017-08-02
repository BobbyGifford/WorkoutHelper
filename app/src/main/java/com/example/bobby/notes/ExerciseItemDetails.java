package com.example.bobby.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseItemDetails extends AppCompatActivity {

    private int exerciseCategory = DefaultList.getExerciseCategory();
    private int exerciseItemId = DefaultList.getExerciseItem();
    private String exerciseName = DefaultList.getDefaultList().get(exerciseCategory)
            .getTestList().get(exerciseItemId).getExerciseName();

    DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_item);

        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        Button buttonRemove = (Button) findViewById(R.id.remove);
        Button buttonEdit = (Button) findViewById(R.id.edit);
        Button buttonToVideo = (Button) findViewById(R.id.videoButton);

        if(DefaultList.getDefaultList().get(exerciseCategory).getTestList()
                .get(exerciseItemId).getIsCustom() == true){
            buttonRemove.setVisibility(View.VISIBLE);
            buttonEdit.setVisibility(View.VISIBLE);
        }

        else {
            buttonToVideo.setVisibility(View.VISIBLE);
        }

        if(this.exerciseItemId != -1){
            title.setText(DefaultList.getDefaultList().get(this.exerciseCategory).getTestList()
                    .get(this.exerciseItemId).getExerciseName());
            desc.setText(DefaultList.getDefaultList().get(DefaultList.getExerciseCategory()).getTestList()
                    .get(DefaultList.getExerciseItem()).getDesc());
        }
    }

    public void remove(View view){
        dbHandler.deleteExerciseByName(exerciseName);
        DefaultList.getDefaultList().get(exerciseCategory).getTestList().remove(exerciseItemId);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void edit(View view){
        Intent intent = new Intent(getApplicationContext(), EditExercise.class);
        startActivity(intent);
    }

    public void toVideo(View view){
        Intent intent = new Intent(getApplicationContext(), Video.class);
        startActivity(intent);
    }
}
