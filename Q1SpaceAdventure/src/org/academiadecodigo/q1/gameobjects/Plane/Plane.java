package org.academiadecodigo.q1.gameobjects.Plane;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Plane implements Collidable, Destroyable, KeyboardHandler {

    private int damage;
    private int life;
    private boolean destroyed;
    private Rectangle planeRect;


    public Plane() {
        this.damage = 0;
        this.life = 3;
        this.planeRect = new Rectangle(380, 840, 40,40);
        this.planeRect.setColor(Color.YELLOW);
        this.planeRect.fill();
    }

    public Rectangle getPlaneRect() {
        return planeRect;
    }

    public boolean isDestroyed() {

        return destroyed;
    }

    public void turnToDestroyed() {

        destroyed = true;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void collide() {

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
                System.out.println("LEFT");
                if (planeRect.getX() == 10) {
                    planeRect.translate(0, 0);
                    break;
                }

                planeRect.translate(-10, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (planeRect.getX() == 770) {
                    planeRect.translate(0, 0);
                    break;
                }
                System.out.println("RIGHT");
                planeRect.translate(10, 0);
                break;

        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
