package org.academiadecodigo.q1.gameobjects.Plane;

import org.academiadecodigo.q1.gameobjects.gameTargets.Target;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Plane implements KeyboardHandler {

    private int life;
    private Picture plane;
    private Picture zeroLives;
    private Picture oneLife;
    private Picture twoLives;
    private Picture threeLives;

    public Plane() {
        this.life = 3;
        this.plane = new Picture(380, 740, "spaceShip_67x85.png");

        threeLives = new Picture(10, 10, "3lives.png");
        twoLives = new Picture(10, 10, "2lives.png");
        oneLife = new Picture(10, 10, "1life.png");
        zeroLives = new Picture(10, 10, "0life.png");
    }

    public void draw() {
        this.plane.draw();
    }

    public void drawLifePictures() {
        switch (life) {
            case 3:
                threeLives.draw();
                break;

            case 2:
               twoLives.draw();
                break;

            case 1:
                oneLife.draw();
                break;

            case 0:
                zeroLives.draw();
        }
    }

    public boolean collide(Target target) {
        int tw = plane.getWidth();
        int th = plane.getHeight();
        int rw = target.getWidth();
        int rh = target.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = plane.getX();
        int ty = plane.getY();
        int rx = target.targetGetX();
        int ry = target.targetGetY();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;

        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    public void movePlane() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life -= life;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (plane.getX() <= 30) {
                    plane.translate(0, 0);
                    break;
                }
                plane.translate(-50, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (plane.getMaxX() >= 780) {
                    plane.translate(0, 0);
                    break;
                }
                plane.translate(50, 0);
                break;

            case KeyboardEvent.KEY_UP:
                if (plane.getY() <= 300) {
                    plane.translate(0, 0);
                    break;
                }
                plane.translate(0, -50);
                break;

            case KeyboardEvent.KEY_DOWN:
                if (plane.getY() >= 780) {
                    plane.translate(0, 0);
                    break;
                }
                plane.translate(0, 50);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
