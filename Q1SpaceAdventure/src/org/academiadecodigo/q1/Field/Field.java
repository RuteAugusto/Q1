package org.academiadecodigo.q1.Field;

import org.academiadecodigo.q1.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field implements Collidable {

    private Rectangle background;

    public Field() {
        background = new Rectangle(10, 10, 800, 900);
        background.fill();
    }


    @Override
    public void collide() {

    }
}
