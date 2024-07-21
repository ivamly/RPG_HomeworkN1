package com.ivmaly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractCharacter implements Mortal {
    private final String name;
    private int health;
    private final int damage;
    private static final Random random = new Random();

    public AbstractCharacter(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public abstract void attackEnemy(List<AbstractCharacter> enemies);

    public void defaultAttack(List<AbstractCharacter> enemies, int damage) {
        AbstractCharacter target = getRandomAliveCharacter(enemies);
        if (target != null) {
            System.out.println(getName() + " attacks " + target.getName() + " and deals " + damage + " damage");
            target.takeDamage(damage);
        }
    }

    public void takeDamage(int damage) {
        if (!isAlive()) {
            return;
        }
        setHealth(getHealth() - damage);
        System.out.println(getName() + " took " + damage + " damage");
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
        }
    }

    public AbstractCharacter getRandomAliveCharacter(List<AbstractCharacter> enemies) {
        if (enemies.isEmpty()) {
            return null;
        }
        List<AbstractCharacter> aliveEnemies = new ArrayList<>();
        for (AbstractCharacter enemy : enemies) {
            if (enemy.isAlive()) {
                aliveEnemies.add(enemy);
            }
        }
        if (!aliveEnemies.isEmpty()) {
            return aliveEnemies.get(random.nextInt(aliveEnemies.size()));
        }
        return null;
    }

    public int getRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
