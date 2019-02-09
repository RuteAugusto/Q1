package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Movable;

public class Asteroid extends Target implements Destroyable, Collidable, Movable {

    private int damage;


    public Asteroid() {
        this.damage = damage;
    }


    @Override
    public void collide() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
