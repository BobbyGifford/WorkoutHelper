package com.example.bobby.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditExercise extends AppCompatActivity {
    private int category = DefaultList.getExerciseCategory();
    private int item = DefaultList.getExerciseItem();
    private String oldExerciseName;
    private String editExerciseName;
    private String editExerciseDesc;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercise);

        dbHandler = new DatabaseHandler(this, null, null, 1);
//        Make changes to DefaultList && call DB edit function.
    }

    public void edit(View view){

        this.oldExerciseName = DefaultList.getDefaultList().get(this.category).getTestList()
                .get(item).getExerciseName();

        EditText newName = (EditText) findViewById(R.id.editName);
        this.editExerciseName = newName.getText().toString();

        EditText newDesc = (EditText) findViewById(R.id.editDesc);
        this.editExerciseDesc = newDesc.getText().toString();

        DefaultList.getDefaultList().get(this.category).getTestList().get(this.item)
                .setExerciseName(this.editExerciseName);
        DefaultList.getDefaultList().get(this.category).getTestList().get(this.item)
                .setDesc(this.editExerciseDesc);

        this.dbHandler.updateByName(this.oldExerciseName, this.editExerciseName, this.editExerciseDesc);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
