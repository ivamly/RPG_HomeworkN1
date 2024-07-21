package com.ivmaly;

import java.util.List;

public class Mage extends AbstractCharacter {
    private static final int BASE_DAMAGE = 10;
    private static final int BASE_HEALTH = 50;
    private static final int FIREBALL_CHANCE = 10;
    private static final int FIREBALL_DAMAGE = 25;

    public Mage(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        if (getRandomNumber() <= FIREBALL_CHANCE) {
            performFireball(enemies);
        } else {
            attack(enemies);
        }
    }

    private void performFireball(List<AbstractCharacter> enemies) {
        AbstractCharacter enemy;
        int index;
        do {
            enemy = getRandomCharacter(enemies);
            index = enemies.indexOf(enemy);
        } while (index == 0 || index == enemies.size() - 1);

        System.out.println(getName() + " performs Fireball!");

        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < enemies.size()) {
                enemies.get(i).takeDamage(FIREBALL_DAMAGE);
            }
        }
    }
}
