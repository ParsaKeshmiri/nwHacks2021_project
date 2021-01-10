package com.kuzon_gaming;

public class GameInstance {

    private String sex;
    private double weightInPounds;

    public int totalSips;
    public int level;
    private int sipsToNextLevel;
    private double dailyIntakeOunces;

    public int drinkingIntervalSeconds;
    public long lastSip = System.currentTimeMillis();

    GameInstance(boolean isMale, int weight) {
        if (isMale) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        totalSips = 0;
        level = 1;
        sipsToNextLevel = 2;
        weightInPounds = weight;
        calculateIntake();
        calculateDrinkingIntervals();
    }

    public void sipWater() {
        if (System.currentTimeMillis() - lastSip > drinkingIntervalSeconds * 1000) {
            totalSips++;
            sipsToNextLevel--;
        }

        System.out.println("Total sips: " + totalSips);
        lastSip = System.currentTimeMillis();

        if (sipsToNextLevel <= 0) {
            levelUp();
        }
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
        System.out.println("Level up! You are now level " + level);
    }

}
