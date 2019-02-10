package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target extends GameObject implements Collidable, Destroyable {

    private TargetType targetType;
    private Field field;
    private TargetFactory targetFactory;
    private int x;
    private int y = 20;
    private final int WIDTH = 60;
    private final int HEIGTH = 60;
    private Rectangle target;


    //private int hitPoints;

    public Target() {
        target = new Rectangle(random(), y, WIDTH, HEIGTH);
        target.setColor(Color.YELLOW);
        target.fill();
    }

    public int random() {

        return (int) (Math.random() * ((780 - 10) + 1)) + 10;
    }

    public void moveTarget(Field field) {

        if(y != field.getHeigth() - 70){
            target.translate(0, +10);
            y +=10;
            return;
        }
        eraseTarget();
    }

    public int getX() {
        return x;
    }

    public int targetGetY() {
        return target.getY();
    }


    public void eraseTarget() {
        target.delete();
    }


    @Override
    public void collide() {

    }

    @Override
    public void destroy() {
    }
}
