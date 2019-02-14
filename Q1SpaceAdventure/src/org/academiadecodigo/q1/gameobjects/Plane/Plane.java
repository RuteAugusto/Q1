package org.academiadecodigo.q1.gameobjects.Plane;

import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Plane implements KeyboardHandler {

    private int life;
    private Picture plane;
    private String scoreIntext;
    private Text scoreText;
    private Picture zeroLives;
    private Picture oneLife;
    private Picture twoLives;
    private Picture threeLives;


    public Plane() {
        this.life = 3;
        this.plane = new Picture(380, 740, "spaceShip_67x85.png");
        this.plane.draw();
        threeLives = new Picture(10, 10, "3lives.png");
        twoLives = new Picture(10, 10, "2lives.png");
        oneLife = new Picture(10, 10, "1life.png");
        zeroLives = new Picture(10, 10, "0life.png");
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life -= life;
    }

    public void setTextScore(int playerScore) {
        scoreIntext = String.valueOf(playerScore);

        scoreText = new Text(700, 100, scoreIntext);
        scoreText.setColor(Color.WHITE);
        scoreText.grow(25, 25);
    }

    public void drawScoreText() {
        scoreText.draw();
    }

    public void deleteScoreText() {
        scoreText.delete();
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
