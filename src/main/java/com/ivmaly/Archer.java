package com.ivmaly;

import java.util.List;

public class Archer extends AbstractCharacter {
    private static final int BASE_DAMAGE = 15;
    private static final int BASE_HEALTH = 70;
    private static final int RAIN_OF_ARROWS_CHANCE = 30;
    private static final int RAIN_OF_ARROWS_DAMAGE = 5;

    public Archer(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        if (getRandomNumber() <= RAIN_OF_ARROWS_CHANCE) {
            System.out.println(getName() + " performs Rain of Arrows!");
            performRainOfArrows(enemies);
        } else {
            attack(enemies);
        }
    }

    private void performRainOfArrows(List<AbstractCharacter> enemies) {
        for (AbstractCharacter character : enemies) {
            character.takeDamage(RAIN_OF_ARROWS_DAMAGE);
        }
    }
}
