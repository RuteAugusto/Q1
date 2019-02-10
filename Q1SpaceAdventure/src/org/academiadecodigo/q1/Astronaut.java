package org.academiadecodigo.q1;

import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Astronaut extends Target {

    private boolean rescued;
    private int damage;
    private int x;
    private int y = 20;
    private Picture astronaut;
    private boolean erased;
    private Rectangle border;
    private int score;

    public Astronaut() {
        this.border = new Rectangle(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y, 34, 55);
        border.setColor(Color.BLACK);
        border.draw();
        this.astronaut = new Picture(border.getX(), y, "resources/astronaut_38x60.png");
        astronaut.draw();
    }

    @Override
    public void moveTarget() {

        if(y != Target.PIXELWHERETODISAPPEAR){
            border.translate(0,1);
            astronaut.translate(0, 1);
            y +=1;
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
        border.delete();
        astronaut.delete();
    }

    public boolean isErased() {
        return erased;
    }

    @Override
    public Picture getRect() {
        return astronaut;
    }

    /*
    public Rectangle getRect() {
        return border;
    }
    */
}
