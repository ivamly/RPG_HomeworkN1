package com.ivmaly;

public abstract class AbstractCharacter implements Mortal {
    private final String name;
    private int health;
    private final int damage;

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

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void takeDamage(int damage);

    public abstract void attackEnemy(AbstractCharacter target);
}
