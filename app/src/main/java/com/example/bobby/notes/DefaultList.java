package com.example.bobby.notes;

import java.util.ArrayList;

/**
 * Created by bobby on 7/17/17.
 */

public abstract class DefaultList {
    private static ArrayList<ExerciseLists> defaultList = new ArrayList<ExerciseLists>() {{
        add(new ExerciseLists("strength"));
        add(new ExerciseLists("cardio"));
    }};

    private static int exerciseCategory;
    private static int exerciseItem;

    public static ArrayList<ExerciseLists> getDefaultList() {
        return defaultList;
    }

    public static void setDefaultList(ArrayList<ExerciseLists> defaultList) {
        DefaultList.defaultList = defaultList;
    }

    public static int getExerciseCategory() {
        return exerciseCategory;
    }


    public static void setExerciseCategory(int exerciseCategory) {
        DefaultList.exerciseCategory = exerciseCategory;
    }

    public static int getExerciseItem() {
        return exerciseItem;
    }

    public static void setExerciseItem(int exerciseItem) {
        DefaultList.exerciseItem = exerciseItem;
    }
}
