package com.ivmaly;

import java.util.List;

public class Vampyre extends AbstractCharacter {
    private static final int BASE_DAMAGE = 25;
    private static final int BASE_HEALTH = 60;
    private static final double HEALING_PERCENT = 0.3;

    public Vampyre(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        attack(enemies);
        heal();
    }

    private void heal() {
        int healingAmount = (int) (getDamage() * HEALING_PERCENT);
        setHealth(getHealth() + healingAmount);
        System.out.println(getName() + " heals for " + healingAmount + " health!");
    }
}
