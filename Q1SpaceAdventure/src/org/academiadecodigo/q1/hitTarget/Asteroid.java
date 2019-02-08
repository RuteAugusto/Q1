package org.academiadecodigo.q1.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Movable;

public class Asteroid extends Target implements Destroyable, Collidable, Movable {

    private int damage;
    private Ellipse ellipse;


    public Asteroid() {
        this.damage = damage;

        ellipse = new Ellipse(random(), 20, 60, 60);

        ellipse.setColor(Color.GRAY);
        ellipse.fill();
    }

    public void erase() {

        ellipse.delete();
    }

    public int random() {

        return (int) (Math.random() * ((780 - 10) + 1)) + 10;
    }



    public void moveTarget() {

        ellipse.translate(0, + 10);

    }

    public int getY(){

        return ellipse.getY();
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
