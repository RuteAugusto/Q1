package org.academiadecodigo.q1.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public  class  Field {

    private Picture background;
    private final int WIDTH = 800;
    private final int HEIGHT = 900;

    public Field() {

        background = new Picture(10, 10, "resources/background_800x900.png");
        background.draw();
    }

    public int getHeigth() {

        return HEIGHT;
    }

    public int getWidth() {

        return WIDTH;
    }

}
