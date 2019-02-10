package org.academiadecodigo.q1;

import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Astronaut extends Target {

    private boolean rescued;
    private int damage;
    private int x;
    private int y = 20;
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private Rectangle astronaut;
    private boolean erased;
    private int score;

    public Astronaut() {
        this.astronaut = new Rectangle(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y, WIDTH, HEIGHT);
        astronaut.setColor(Color.BLUE);
        astronaut.fill();
    }

    @Override
    public void moveTarget() {

        if(y != Target.PIXELWHERETODISAPPEAR){
            astronaut.translate(0, 5);
            y +=5;
            return;
        }
        eraseTarget();
    }

    @Override
    public int targetGetY() {
        return astronaut.getY();
    }

    @Override
    public void eraseTarget() {
        erased = true;
        astronaut.delete();
    }

    public boolean isErased() {
        return erased;
    }

    @Override
    public Rectangle getRect() {
        return astronaut;
    }
}
