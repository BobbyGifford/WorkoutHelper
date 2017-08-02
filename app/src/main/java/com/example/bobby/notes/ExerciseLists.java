package com.example.bobby.notes;

import java.util.ArrayList;

/**
 * Created by bobby on 7/13/17.
 */

public class ExerciseLists{
    private String category;
    protected ArrayList<Exercises> testList = new ArrayList<>();

    public ExerciseLists(String category) {
        if(category.toLowerCase() == "strength") {
            this.category = "Strength";
            Exercises benchPress = new Exercises("Bench Press", "Bench presses with a barbell." +
                    "A very typical exercise", false);
            Exercises squat = new Exercises("Squat", "As named.", false);
            this.testList.add(benchPress);
            this.testList.add(squat);
        }

        if(category.toLowerCase() == "cardio") {
            this.category = "Cardio";
            Exercises jog = new Exercises("Long distance jog", "Distance run", false);
            Exercises run = new Exercises("Quick sprint", "Quick sprints", false);
            Exercises kickBoxing = new Exercises("Kick Boxing", "This is to make sure the app is " +
                    "running. Kickboxing is hard", false);
            this.testList.add(jog);
            this.testList.add(run);
            this.testList.add(kickBoxing);
        }

    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Exercises> getTestList() {
        return this.testList;
    }

    public void setTestList(ArrayList<Exercises> testList) {
        this.testList = testList;
    }

    @Override
    public String toString() {
        return this.getCategory();
    }
}
