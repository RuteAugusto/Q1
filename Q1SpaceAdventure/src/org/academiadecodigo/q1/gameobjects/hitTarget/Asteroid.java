package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid extends Target implements Destroyable, Collidable, Movable {

    private int damage;
    private int x;
    private int y = 20;
    private Picture asteroid;
    private Rectangle border;
    private boolean erased;

    public Asteroid() {
        this.border = new Rectangle(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y + 5, 75, 75);
        border.draw();
        this.asteroid = new Picture(border.getX(), y, "resources/asteroid_80x90.png");
        asteroid.draw();
    }


    public void moveTarget() {

        if(y != Target.PIXELWHERETODISAPPEAR){
            border.translate(0,1);
            asteroid.translate(0, 1);
            y +=1;
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
        border.delete();
        asteroid.delete();
    }

    public boolean isErased() {
        return erased;
    }

    @Override
    public Picture getRect() {
        return asteroid;
    }

    /*
    public Rectangle getRect() {
        return border;
    }
    */

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
