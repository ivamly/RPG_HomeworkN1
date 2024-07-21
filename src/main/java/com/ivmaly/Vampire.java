package com.ivmaly;

import java.util.List;

public class Vampire extends AbstractCharacter {
    private static final int BASE_DAMAGE = 25;
    private static final int BASE_HEALTH = 60;
    private static final double HEALING_PERCENT = 0.3;

    public Vampire(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        defaultAttack(enemies, BASE_DAMAGE);
        int healingAmount = (int) (BASE_DAMAGE * HEALING_PERCENT);
        setHealth(getHealth() + healingAmount);
        System.out.println(getName() + " heals for " + healingAmount + " health");
    }
}
