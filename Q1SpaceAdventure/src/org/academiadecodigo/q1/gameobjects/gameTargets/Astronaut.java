package org.academiadecodigo.q1.gameobjects.gameTargets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Astronaut extends Target {

    private int y = 20;
    private boolean erased;
    private Picture astronaut;

    public Astronaut() {
        this.astronaut = new Picture(random(Target.MIN_PIXEL_WHERE_TO_APPEAR, Target.MAX_PIXEL_WHERE_TO_APPEAR),
                y, "astronaut_38x60.png");
        astronaut.draw();
    }

    @Override
    public void moveTarget() {
        if (y != Target.PIXEL_WHERE_TO_DISAPPEAR) {
            astronaut.translate(0, 2);
            y += 2;
            return;
        }
        eraseTarget();
    }

    public boolean isErased() {
        return erased;
    }

    @Override
    public void eraseTarget() {
        erased = true;
        astronaut.delete();
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
    public int getHeight() {
        return astronaut.getHeight();
    }

    @Override
    public int getWidth() {
        return astronaut.getWidth();
    }
}
