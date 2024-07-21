package com.ivmaly;

import java.util.List;

public class Goblin extends AbstractCharacter {
    private static final int BASE_DAMAGE = 20;
    private static final int BASE_HEALTH = 70;
    private static final int CRITICAL_HIT_CHANCE = 20;
    private static final double CRITICAL_HIT_MULTIPLIER = 1.5;

    public Goblin(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        if (getRandomNumber() <= CRITICAL_HIT_CHANCE) {
            performCriticalHit(enemies);
        } else {
            attack(enemies);
        }
    }

    private void performCriticalHit(List<AbstractCharacter> enemies) {
        System.out.println(getName() + " performs a critical hit!");
        getRandomCharacter(enemies).takeDamage((int) (getDamage() * CRITICAL_HIT_MULTIPLIER));
    }
}
