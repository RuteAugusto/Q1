package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.Plane.Plane;
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
    private Ellipse  planeRect2;


    public Game() {

    }

    public void init() {
        field = new Field();
        planeRect = new Rectangle(380, 840, 40, 40);
        planeRect2 = new Ellipse(450, 805, 40, 40);
        planeRect2.setColor(Color.BLUE);
        planeRect.setColor(Color.YELLOW);
        planeRect.fill();
        planeRect2.fill();


        player = new Player();
        plane = new Plane(planeRect);
        target = new Target();

    }

    public void start() throws InterruptedException {
        movePlane();

        Thread.sleep(2000);
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
                if (planeRect.getX() == 10) {
                    planeRect.translate(0, 0);

                    break;
                }
                if (planeRect.getX() == (planeRect2.getX() + 40 )) {
                    System.out.println("bateu");
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
                if (planeRect.getX() == (planeRect2.getX() - 40)) {
                    System.out.println("bateu");
                    planeRect.translate(0,0);
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
