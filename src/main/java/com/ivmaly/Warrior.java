package com.ivmaly;

import java.util.List;

public class Warrior extends AbstractCharacter {
    private static final int BASE_DAMAGE = 20;
    private static final int BASE_HEALTH = 100;
    private static final int DOUBLE_ATTACK_CHANCE = 20;

    public Warrior(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        if (getRandomNumber() <= DOUBLE_ATTACK_CHANCE) {
            System.out.println(getName() + " performs a double attack!");
            performDoubleAttack(enemies);
        } else {
            attack(enemies);
        }
    }

    private void performDoubleAttack(List<AbstractCharacter> enemies) {
        attack(enemies);
        attack(enemies);
    }
}
