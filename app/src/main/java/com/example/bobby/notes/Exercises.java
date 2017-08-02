package com.example.bobby.notes;

/**
 * Created by bobby on 7/13/17.
 */

public class Exercises {
    private String exerciseName;
    private String desc;
    private boolean isCustom;

    public Exercises(String exerciseName, String desc, boolean isCustom) {
        this.exerciseName = exerciseName;
        this.desc = desc;
        this.isCustom = isCustom;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean getIsCustom() {
        return isCustom;
    }


    @Override
    public String toString() {
        return this.exerciseName;
    }
}
