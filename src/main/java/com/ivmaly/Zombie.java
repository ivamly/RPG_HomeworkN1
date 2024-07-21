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
        attack(enemies);
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() <= 0) {
            if (!isRevived) {
                revive();
            } else {
                System.out.println(getName() + " is dead!");
            }
        }
    }

    private void revive() {
        isRevived = true;
        setHealth(BASE_HEALTH);
        System.out.println(getName() + " revived!");
    }
}
