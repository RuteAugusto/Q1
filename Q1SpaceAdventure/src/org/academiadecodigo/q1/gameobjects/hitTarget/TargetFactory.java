package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Astronaut;

public class TargetFactory {

    public static Target createTarget() {

        int randomNumber = (int) Math.floor(Math.random() * 100) + 1;

        TargetType[] targetType = TargetType.values();

        TargetType newType = targetType[0];


        if (randomNumber <= 10) {
            return new Asteroid();
        }

        if (randomNumber > 10) {
            return new Astronaut();
        }

        return null;
    }

}
