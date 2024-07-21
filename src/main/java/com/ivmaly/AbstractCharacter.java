package com.ivmaly;

import java.util.List;
import java.util.Random;

public abstract class AbstractCharacter implements Mortal, CombatAction {
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

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        if (!isAlive()) {
            System.out.println(name + " is dead!");
        }
    }

    @Override
    public void attack(List<AbstractCharacter> characters) {
        AbstractCharacter character = getRandomCharacter(characters);
        character.takeDamage(damage);
    }

    public abstract void attackEnemy(List<AbstractCharacter> enemies);

    public AbstractCharacter getRandomCharacter(List<AbstractCharacter> enemies) {
        return enemies.get(random.nextInt(enemies.size()));
    }

    public int getRandomNumber() {
        return random.nextInt(100) + 1;
    }
}
