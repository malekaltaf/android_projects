package com.example.workoutapp;

import java.util.ArrayList;
import java.util.List;

public class workout {
    List <String> getWorkout (String workouttypes)
    {
        List <String> workoutt = new ArrayList<String>();

        if (workouttypes.equals("Samsung"))
        {
            workoutt.add("Galaxy A51");
            workoutt.add("Galaxy A71");
        }
        else if (workouttypes.equals("Nokia"))
        {
            workoutt.add("8.1 5G");
            workoutt.add("2.4 2G");
        }
        else if (workouttypes.equals("Apple"))
        {
            workoutt.add("iPhone 11");
            workoutt.add("iPhone 12");
        }
        else if (workouttypes.equals("Xiaomi"))
        {
            workoutt.add("Note 10");
            workoutt.add("K20 Pro");
        }
        else if (workouttypes.equals("Oneplus"))
        {
            workoutt.add("9 Pro");
            workoutt.add("7 Pro");
        }
        return workoutt;


    }
}
