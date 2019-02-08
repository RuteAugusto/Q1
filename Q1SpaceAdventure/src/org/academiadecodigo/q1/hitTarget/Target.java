package org.academiadecodigo.q1.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.q1.Field.Field;

public class Target implements Collidable, Destroyable {

    private TargetType targetType;
    private Field field;
    private Asteroid asteroid;

    //private int hitPoints;

    /*
    public void moveTarget() {

        //boolean bottom = false;

        asteroid.translate(0,10);

    }
    */

    public void eraseTarget() {

    }

    @Override
    public void collide() {

    }

    @Override
    public void destroy() {
    }
}
