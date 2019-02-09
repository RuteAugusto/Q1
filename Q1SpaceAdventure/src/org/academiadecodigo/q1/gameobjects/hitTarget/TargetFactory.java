package org.academiadecodigo.q1.gameobjects.hitTarget;

public class TargetFactory {

    public static Target createTarget() {

        TargetType[] targetType = TargetType.values();

        TargetType newType = targetType[0];

        switch (newType) {

            case ASTEROID:
                return new Asteroid();
        }

        return null;
    }

}
