package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.GameObject;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private Target target;
    private Asteroid asteroid;
    private GameObject[] gameObjects;

    public Game() {

    }

    public void init() {

        field = new Field();
        player = new Player();
        plane = new Plane();

    }

    public void start() throws InterruptedException {

        this.target = TargetFactory.createTarget();
        plane.movePlane();
       while (true) {
           Thread.sleep(200);
           target.moveTarget(field);
       }
    }



}
