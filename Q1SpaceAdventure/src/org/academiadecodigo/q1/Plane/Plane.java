package org.academiadecodigo.q1.Plane;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Plane implements Collidable, Destroyable {

    private int damage;
    private int life;
    private boolean destroyed;
    private Rectangle plane;


    public Plane(Rectangle plane) {
        this.damage = 0;
        this.life = 3;
        this.plane = plane;

    }




    public void setPlane(Rectangle plane) {
        this.plane = plane;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void turnToDestroyed() {
        destroyed = true;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void collide() {

    }


}
