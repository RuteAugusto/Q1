package org.academiadecodigo.simplegraphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Q1Test implements KeyboardHandler{

    private Rectangle plane;

    public Q1Test(Rectangle plane) {
        this.plane = plane;
    }

    public static void main(String[] args) throws InterruptedException {


        Rectangle background = new Rectangle(10, 10, 400, 400);
        background.setColor(Color.BLACK);
        background.fill();

        Rectangle plane = new Rectangle(200, 370, 30, 30);
        plane.setColor(Color.YELLOW);
        plane.fill();

        Q1Test q1test = new Q1Test(plane);
        q1test.test3();

    }


    public void test3() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);


        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

    }


    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                System.out.println("LEFT");

                plane.translate(-10, 0);
                break;

            default:
                System.out.println("RIGHT");
                plane.translate(10, 0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
