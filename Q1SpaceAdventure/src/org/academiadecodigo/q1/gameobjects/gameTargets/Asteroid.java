package org.academiadecodigo.q1.gameobjects.gameTargets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid extends Target {

    private int y = 20;
    private boolean erased;
    private Picture asteroid;

    public Asteroid() {
        this.asteroid = new Picture(random(Target.MIN_PIXEL_WHERE_TO_APPEAR, Target.MAX_PIXEL_WHERE_TO_APPEAR),
                y, "asteroid_80x90.png");
        asteroid.draw();
    }

    public void moveTarget() {
        if(y != Target.PIXEL_WHERE_TO_DISAPPEAR){
            asteroid.translate(0, 2);
            y +=2;
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
        asteroid.delete();
    }

    @Override
    public int targetGetY() {
        return asteroid.getY();
    }

    @Override
    public int targetGetX() {
        return asteroid.getX();
    }

    @Override
    public int getHeight() {
        return asteroid.getHeight();
    }

    @Override
    public int getWidth() {
        return asteroid.getWidth();
    }
}
