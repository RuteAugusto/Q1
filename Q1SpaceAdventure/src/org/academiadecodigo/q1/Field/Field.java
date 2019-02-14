package org.academiadecodigo.q1.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public  class  Field {

    private final int HEIGHT = 900;
    private Picture background;

    public Field() {
        background = new Picture(10, 10, "background_800x900.png");
    }

    public void draw() {
        background.draw();
    }

    public int getHeight() {
        return HEIGHT;
    }
}
