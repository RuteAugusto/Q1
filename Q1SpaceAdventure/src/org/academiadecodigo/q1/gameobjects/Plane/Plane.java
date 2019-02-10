package org.academiadecodigo.q1.gameobjects.Plane;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.q1.Destroyable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Plane implements Collidable, Destroyable, KeyboardHandler {

    private int damage;
    private int life;
    private boolean destroyed;
    private Picture plane;
    private Rectangle border;


    public Plane() {
        this.damage = 0;
        this.life = 3;
        this.border = new Rectangle (380, 740, 67, 85);
        this.plane = new Picture(380, 740, "resources/spaceShip_67x85.png");
        this.plane.draw();
    }

    public Picture getPlaneRect() {
        return plane;
    }

    public Rectangle getRect() {
        return border;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void turnToDestroyed() {
        destroyed = true;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage += damage;

        if (damage == 100) {
            turnToDestroyed();
        }

    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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
                if (plane.getX() == 20) {
                    plane.translate(0, 0);
                    break;
                }

                plane.translate(-20, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (plane.getMaxX() >= 800) {
                    plane.translate(0, 0);
                    break;
                }
                System.out.println("RIGHT");
                plane.translate(20, 0);
                break;

        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
