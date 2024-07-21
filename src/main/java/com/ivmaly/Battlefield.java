package com.ivmaly;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
    public static void main(String[] args) {
        // Создаем список героев
        List<AbstractCharacter> heroes = new ArrayList<>();
        heroes.add(new Warrior("Heroic Warrior"));
        heroes.add(new Mage("Mystic Mage"));
        heroes.add(new Archer("Swift Archer"));

        // Создаем список противников
        List<AbstractCharacter> enemies = new ArrayList<>();
        enemies.add(new Goblin("Goblin Grunt"));
        enemies.add(new Zombie("Undead Zombie"));
        enemies.add(new Vampyre("Bloodthirsty Vampyre"));

        // Печатаем начальное состояние
        System.out.println("Initial State:");
        printCharacters(heroes, "Heroes");
        printCharacters(enemies, "Enemies");

        // Симулируем бой
        System.out.println("\nBattle begins!");

        while (charactersAlive(heroes) && charactersAlive(enemies)) {
            for (AbstractCharacter hero : heroes) {
                if (charactersAlive(enemies)) {
                    hero.attackEnemy(enemies);
                }
            }

            for (AbstractCharacter enemy : enemies) {
                if (charactersAlive(heroes)) {
                    enemy.attackEnemy(heroes);
                }
            }

            // Печатаем состояние после каждого раунда
            System.out.println("\nCurrent State:");
            printCharacters(heroes, "Heroes");
            printCharacters(enemies, "Enemies");
        }

        // Печатаем результат боя
        if (charactersAlive(heroes)) {
            System.out.println("\nHeroes win!");
        } else {
            System.out.println("\nEnemies win!");
        }
    }

    private static void printCharacters(List<AbstractCharacter> characters, String group) {
        System.out.println(group + ":");
        for (AbstractCharacter character : characters) {
            System.out.println(character.getName() + " - Health: " + character.getHealth());
        }
    }

    private static boolean charactersAlive(List<AbstractCharacter> characters) {
        for (AbstractCharacter character : characters) {
            if (character.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
