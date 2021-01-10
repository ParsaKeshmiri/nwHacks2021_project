package com.kuzon_gaming;

public class GameInstance {

    private String sex;
    private double weightInPounds;

    public int totalSips;
    public int level;
    public String title;
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
        title = "Dehydrated Person";
        weightInPounds = weight;
        calculateIntake();
        calculateDrinkingIntervals();
    }

    public void sipWater() {
        if (System.currentTimeMillis() - lastSip > drinkingIntervalSeconds * 1000) {
            totalSips++;
            sipsToNextLevel--;
        }

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

        switch (level) {
            case 1:
                title = "Dehydrated Person";
                break;
            case 2:
                title = "Water Drinking Novice";
                break;
            case 3:
                title = "Hydrated Person";
                break;
            case 4:
                title = "Advanced Water Drinker";
                break;
            case 5:
                title = "Sipping Soldier";
                break;
            case 6:
                title = "Sipping Champion";
                break;
            case 7:
                title = "Sipping Grandmaster";
                break;
            case 8:
                title = "Hydro Homie";
                break;
            case 9:
                title = "Hydro Hero";
                break;
            case 10:
                title = "Posideon's Offspring";
                break;
            case 11:
                title = "Drinking Deity";
                break;
            default:
                title = "Quenched";
                break;
        }
    }

}
