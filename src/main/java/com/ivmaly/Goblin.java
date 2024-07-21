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
        int attackDamage = getDamage();
        if (getRandomNumber(100) <= CRITICAL_HIT_CHANCE) {
            attackDamage = (int) (getDamage() * CRITICAL_HIT_MULTIPLIER);
            System.out.println(getName() + " performs a critical hit!");
        }
        defaultAttack(enemies, attackDamage);
    }
}
