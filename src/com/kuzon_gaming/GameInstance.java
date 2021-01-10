package com.kuzon_gaming;

public class GameInstance {

    private String sex;
    private int weightInPounds;


    private int dailyIntakeOunces;
    private int level;
    private int sipsToNextLevel;

    GameInstance(boolean isMale, int weight) {
        if (isMale) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        weightInPounds = weight;
    }


    /**
     * Calculates recommended daily intake based on user's sex and weight
     */
    private void calculateIntake() {
        if (sex.equals("Male")) {
            dailyIntakeOunces = weightInPounds * 2 / 3;
        } else {
            dailyIntakeOunces = weightInPounds * 2 / 3 - 10;
        }
    }

    /**
     * Updates user's level and level progression
     */
    private void levelUp() {
        level++;
        sipsToNextLevel = level * 2;
    }

}
