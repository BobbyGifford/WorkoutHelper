package com.example.bobby.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExercisesOfCategory extends AppCompatActivity {

    private int exerciseCategory = DefaultList.getExerciseCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises_of_category);

        ListView listView = (ListView) findViewById(R.id.exerciseItemNames);
        final ArrayAdapter arrayAdapter;

        if(exerciseCategory != -1){
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                    DefaultList.getDefaultList().get(this.exerciseCategory).getTestList());

            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(getApplicationContext(), ExerciseItemDetails.class);
                    DefaultList.setExerciseItem(i);
                    startActivity(intent1);
                }
            });

        }

    }

    public void addCustomExercise(View view){

        Intent intent = new Intent(getApplicationContext(), AddCustomExercise.class);
        startActivity(intent);
    }
}
