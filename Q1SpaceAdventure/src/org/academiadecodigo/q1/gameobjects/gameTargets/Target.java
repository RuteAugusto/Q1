package org.academiadecodigo.q1.gameobjects.gameTargets;


public abstract class Target {

    public static final int MIN_PIXEL_WHERE_TO_APPEAR = 30;
    public static final int MAX_PIXEL_WHERE_TO_APPEAR = 710;
    public static final int PIXEL_WHERE_TO_DISAPPEAR = 820;

    public int random(int min, int max) {
        return  (int) (Math.random() * (max - min) + 1);
    }

    public abstract void moveTarget();

    public abstract int targetGetY();

    public abstract int targetGetX();

    public abstract void eraseTarget();

    public abstract boolean isErased();

    public abstract int getHeight();

    public abstract int getWidth();
}
