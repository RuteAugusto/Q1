package org.academiadecodigo.q1;

import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Astronaut extends Target {

    private int y = 20;
    private Picture astronaut;
    private boolean erased;

    public Astronaut() {
        this.astronaut = new Picture(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y, "resources/astronaut_38x60.png");
        astronaut.draw();
    }

    @Override
    public void moveTarget() {

        if (y != Target.PIXELWHERETODISAPPEAR) {
            astronaut.translate(0, 2);
            y += 2;
            return;
        }
        eraseTarget();
    }

    @Override
    public int targetGetY() {
        return astronaut.getY();
    }

    @Override
    public int targetGetX() {
        return astronaut.getX();
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
    public int getHeight() {
        return astronaut.getHeight();
    }

    @Override
    public int getWidth() {
        return astronaut.getWidth();
    }
}
