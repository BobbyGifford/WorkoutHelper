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
            Exercises benchPress = new Exercises("Bench Press",
                    "The person performing the exercise lies on their back on a bench with a weight grasped in both hands. " +
                    "They push the weight upwards until their arms are extended, not allowing the elbows to lock. " +
                    "They then lower the weight to chest level.",
                    false);
            Exercises squat = new Exercises("Squat", "The movement begins from a standing position. Weights are often used, " +
                    "either in the hand (dumbbells or kettlebells) or as a bar braced across the trapezius muscle or rear deltoid muscle in the upper back." +
                    "The movement is initiated by moving the hips back and bending the knees and hips to lower the torso and accompanying weight, " +
                    "then returning to the upright position.",
                    false);
            Exercises pullDown = new Exercises("Pull Down", "The pulldown usually uses a weight machine with a seat and brace for the thighs." +
                    " The starting position involves sitting at the machine with the thighs braced, back straight and feet flat on the floor. " +
                    "The arms are held overhead at full extension, grasping a bar connected to the weight stack. The movement is initiated by pulling the elbows down and back, " +
                    "lowering the bar to the neck, and completed by returning to the initial position.",
                    false);
            this.testList.add(benchPress);
            this.testList.add(squat);
            this.testList.add(pullDown);
        }

        if(category.toLowerCase() == "cardio") {
            this.category = "Cardio";
            Exercises jog = new Exercises("Long distance jog", "This is more about endurance. Pace yourself well and don't" +
                    "run fast early in the exercise", false);
            Exercises run = new Exercises("Quick sprint", "This is the opposite of the distance run." +
                    "Run at a high pace for short repetitions ", false);
            Exercises indoorCylcing = new Exercises("Indoor Cycling","Indoor bike machines are an extremely useful" +
                    "cardio workout. They have various setting for resistance and are very quiet."
                    , false);
            this.testList.add(jog);
            this.testList.add(run);
            this.testList.add(indoorCylcing);
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
