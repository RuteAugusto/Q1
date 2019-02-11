package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Destroyable;


public abstract class Target implements Destroyable {

    public static final int MINPixelWhereToAppear = 20;
    public static final int MAXPixelWhereToAppear = 710;
    public static final int PIXELWHERETODISAPPEAR = 820;



    public int random(int min, int max) {
        return  (int) (Math.random() * (max - min) + 1);
    }

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void moveTarget();

    public abstract int targetGetY();

    public abstract int targetGetX();

    public abstract void eraseTarget();

    public abstract boolean isErased();



    @Override
    public void destroy() {
    }
}
