package com.ivmaly;

import java.util.List;

public class Mage extends AbstractCharacter {
    private static final int BASE_DAMAGE = 10;
    private static final int BASE_HEALTH = 50;
    private static final int FIREBALL_CHANCE = 10;
    private static final int FIREBALL_DAMAGE = 30;

    public Mage(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        if (getRandomNumber(100) > FIREBALL_CHANCE) {
            defaultAttack(enemies, BASE_DAMAGE);
        } else {
            System.out.println(getName() + " creates a fireball!");
            for (int i = 0; i < 3 && !enemies.isEmpty(); i++) {
                AbstractCharacter target = getRandomAliveCharacter(enemies);
                if (target != null) {
                    System.out.println(getName() + " hits " + target.getName() + " with Fireball for " + FIREBALL_DAMAGE + " damage");
                    target.takeDamage(FIREBALL_DAMAGE);
                }
            }
        }
    }
}
