package org.academiadecodigo.q1.gameobjects.hitTarget;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid extends Target {

    private int y = 20;
    private boolean erased;
    private Picture asteroid;

    public Asteroid() {
        this.asteroid = new Picture(random(Target.MINPixelWhereToAppear, Target.MAXPixelWhereToAppear), y, "asteroid_80x90.png");
        asteroid.draw();
    }

    public void moveTarget() {
        if(y != Target.PIXELWHERETODISAPPEAR){
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
