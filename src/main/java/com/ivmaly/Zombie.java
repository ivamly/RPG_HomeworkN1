package com.ivmaly;

import java.util.List;

public class Zombie extends AbstractCharacter {
    private static final int BASE_DAMAGE = 10;
    private static final int BASE_HEALTH = 80;
    private boolean isRevived = false;

    public Zombie(String name) {
        super(name, BASE_HEALTH, BASE_DAMAGE);
    }

    @Override
    public void attackEnemy(List<AbstractCharacter> enemies) {
        defaultAttack(enemies, BASE_DAMAGE);
    }

    @Override
    public void takeDamage(int damage) {
        if (!isAlive()) {
            if (!isRevived) {
                isRevived = true;
                setHealth(BASE_HEALTH);
                System.out.println(getName() + " is revived with full health!");
            }
            return;
        }
        setHealth(getHealth() - damage);
        System.out.println(getName() + " took " + damage + " damage");
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
        }
    }
}
