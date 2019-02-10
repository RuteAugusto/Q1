package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Asteroid extends Target implements Destroyable, Collidable, Movable {

    private int damage;
    private int x;
    private int y = 20;
    private final int WIDTH = 60;
    private final int HEIGHT = 60;
    private Rectangle asteroid;
    private boolean erased;

    public Asteroid() {
        this.asteroid = new Rectangle(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y, WIDTH, HEIGHT);
        asteroid.setColor(Color.GRAY);
        asteroid.fill();
    }


    public void moveTarget() {

        if(y != Target.PIXELWHERETODISAPPEAR){
            asteroid.translate(0, 5);
            y +=5;
            return;
        }
        eraseTarget();
    }

    @Override
    public int targetGetY() {
        return asteroid.getY();
    }

    @Override
    public void eraseTarget() {
        erased = true;
        asteroid.delete();
    }

    public boolean isErased() {
        return erased;
    }

    @Override
    public Rectangle getRect() {
        return asteroid;
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
