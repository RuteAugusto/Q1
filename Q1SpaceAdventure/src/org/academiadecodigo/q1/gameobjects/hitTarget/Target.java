package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Target extends GameObject implements Collidable, Destroyable {

    private TargetType targetType;
    private Field field;
    private TargetFactory targetFactory;
    private int x;
    private int y = 20;
    private final int WIDTH = 60;
    private final int HEIGHT = 60;
    public static final int MINPixelWhereToAppear = 20;
    public static final int MAXPixelWhereToAppear = 710;
    public static final int PIXELWHERETODISAPPEAR = 850;


    //private int hitPoints;
    /*
    public Target() {
        target = new Rectangle(random(20, 710), y, WIDTH, HEIGHT);
        target.setColor(Color.YELLOW);
        target.fill();
    }
    */

    public int random(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }


    public abstract void moveTarget();

    public abstract int targetGetY();

    /*
    public int getX() {
        return x;
    }
    */

    public abstract Rectangle getRect();

    public abstract void eraseTarget();

    public abstract boolean isErased();

    @Override
    public void collide() {

    }

    @Override
    public void destroy() {
    }
}
