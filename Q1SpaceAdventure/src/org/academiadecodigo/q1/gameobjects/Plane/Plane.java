package org.academiadecodigo.q1.gameobjects.Plane;

import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Plane implements KeyboardHandler {

    private int life;
    private Picture plane;


    public Plane() {
        this.life = 3;
        this.plane = new Picture(380, 740, "resources/spaceShip_67x85.png");
        this.plane.draw();
    }


    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life -= life;
    }


    public boolean collide(Target obj) {
        int tw = plane.getWidth();
        int th = plane.getHeight();
        int rw = obj.getWidth();
        int rh = obj.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = plane.getX();
        int ty = plane.getY();
        int rx = obj.targetGetX();
        int ry = obj.targetGetY();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
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

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
