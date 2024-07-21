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
        if (getRandomNumber(100) <= RAIN_OF_ARROWS_CHANCE) {
            System.out.println(getName() + " performs a rain of arrows!");
            for (AbstractCharacter enemy : enemies) {
                if (enemy.isAlive()) {
                    System.out.println(getName() + " hits " + enemy.getName() + " with rain of arrows for " + RAIN_OF_ARROWS_DAMAGE + " damage");
                    enemy.takeDamage(RAIN_OF_ARROWS_DAMAGE);
                }
            }
        } else {
            defaultAttack(enemies, BASE_DAMAGE);
        }
    }
}
