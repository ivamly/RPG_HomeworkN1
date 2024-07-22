package com.ivmaly;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<AbstractCharacter> team1;
    private final List<AbstractCharacter> team2;

    public Game(List<AbstractCharacter> team1, List<AbstractCharacter> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void start() {
        System.out.println("Battle begins!");

        while (hasAliveCharacters(team1) && hasAliveCharacters(team2)) {
            for (AbstractCharacter attacker : team1) {
                if (!hasAliveCharacters(team2)) break;
                if (attacker.isAlive()) {
                    attacker.attackEnemy(team2);
                }
            }

            if (!hasAliveCharacters(team2)) {
                break;
            }

            for (AbstractCharacter attacker : team2) {
                if (!hasAliveCharacters(team1)) break;
                if (attacker.isAlive()) {
                    attacker.attackEnemy(team1);
                }
            }

            if (!hasAliveCharacters(team1)) {
                break;
            }
        }

        endGame();
    }

    private boolean hasAliveCharacters(List<AbstractCharacter> team) {
        for (AbstractCharacter character : team) {
            if (character.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void endGame() {
        if (!hasAliveCharacters(team1)) {
            System.out.println("Team 1 is defeated. Team 2 wins!");
        } else if (!hasAliveCharacters(team2)) {
            System.out.println("Team 2 is defeated. Team 1 wins!");
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }

    public static void main(String[] args) {
        List<AbstractCharacter> team1 = new ArrayList<>();
        List<AbstractCharacter> team2 = new ArrayList<>();

        team1.add(new Warrior("Warrior1"));
        team1.add(new Mage("Mage1"));
        team1.add(new Archer("Archer1"));

        team2.add(new Goblin("Goblin1"));
        team2.add(new Zombie("Zombie1"));
        team2.add(new Vampire("Vampire1"));

        Game game = new Game(team1, team2);
        game.start();
    }
}
