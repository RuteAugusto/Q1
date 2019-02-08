package org.academiadecodigo.q1.Field;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field implements Collidable {

    private Rectangle background;
    private final int WIDTH = 800;
    private final int HEIGTH = 900;

    public Field() {

        background = new Rectangle(10, 10, WIDTH, HEIGTH);
        background.fill();
    }

    public int getHeigth() {

        return HEIGTH;
    }

    public int getWidth() {

        return WIDTH;
    }

    @Override
    public void collide() {

    }
}
