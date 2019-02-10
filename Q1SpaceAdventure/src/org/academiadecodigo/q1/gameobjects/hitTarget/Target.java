package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Target implements Collidable, Destroyable {

    public static final int MINPixelWhereToAppear = 20;
    public static final int MAXPixelWhereToAppear = 710;
    public static final int PIXELWHERETODISAPPEAR = 820;


    public int random(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }


    public abstract void moveTarget();

    public abstract int targetGetY();

    public abstract Picture getRect();

    public abstract void eraseTarget();

    public abstract boolean isErased();

    //public abstract Rectangle getRect();

    @Override
    public void collide() {

    }

    @Override
    public void destroy() {
    }
}
