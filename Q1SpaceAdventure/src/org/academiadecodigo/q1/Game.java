package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.Plane.Plane;
import org.academiadecodigo.q1.hitTarget.Asteroid;
import org.academiadecodigo.q1.hitTarget.Target;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Player player;
    private Plane plane;
    private Field field;
    private Target target;
    private Rectangle planeRect;
    private Asteroid asteroid;

    public Game() {

    }

    public void init() {

        field = new Field();
        planeRect = new Rectangle(380, 840, 40, 40);
        planeRect.setColor(Color.YELLOW);
        planeRect.fill();

        asteroid = new Asteroid();
        player = new Player();
        plane = new Plane(planeRect);
        target = new Target();

    }

    public void start() throws InterruptedException {

        movePlane();

        while (asteroid.getY() != 850) {

            Thread.sleep(200);
            asteroid.moveTarget();
        }

        asteroid.erase();
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

    public void moveTargets() {

    }

    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                System.out.println("LEFT");
                planeRect.translate(-10, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                System.out.println("RIGHT");
                planeRect.translate(10, 0);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
