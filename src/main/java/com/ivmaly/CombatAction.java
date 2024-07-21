package com.ivmaly;

import java.util.List;

public interface CombatAction {
    void takeDamage(int damage);

    void attack(List<AbstractCharacter> characters);
}
