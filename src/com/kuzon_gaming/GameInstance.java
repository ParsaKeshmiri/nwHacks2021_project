package com.kuzon_gaming;

public class GameInstance {

    private String sex;
    private double weightInPounds;

    private int level;
    private int sipsToNextLevel;
    private double dailyIntakeOunces;

    public int drinkingIntervalSeconds;
    public long lastSip;

    public int displayMinutes;
    public int displaySeconds;

    GameInstance(boolean isMale, int weight) {
        if (isMale) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        weightInPounds = weight;
        calculateIntake();
        calculateDrinkingIntervals();
    }

    public void running() {


    }

    public void updateCountdown() {
        displayMinutes = (int) ((lastSip + drinkingIntervalSeconds * 1000 - System.currentTimeMillis()) / 1000) / 60;
        displaySeconds = (int) ((lastSip + drinkingIntervalSeconds * 1000 - System.currentTimeMillis()) / 1000) % 60;
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
     * Calculates time between sips
     */
    private void calculateDrinkingIntervals() {
        drinkingIntervalSeconds = (int) (24 * 16 / dailyIntakeOunces * 2 * 60);
    }

    /**
     * Updates user's level and level progression
     */
    private void levelUp() {
        level++;
        sipsToNextLevel = level * 2;
    }

}
