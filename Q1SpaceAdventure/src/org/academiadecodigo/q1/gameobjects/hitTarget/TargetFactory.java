package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Astronaut;

public class TargetFactory {

    public static Target createTarget() {
        int randomNumber = (int) Math.floor(Math.random() * 100) + 1;

        if (randomNumber <= 79) {
            return new Asteroid();
        }

        if (randomNumber > 79) {
            return new Astronaut();
        }
        return null;
    }
}
