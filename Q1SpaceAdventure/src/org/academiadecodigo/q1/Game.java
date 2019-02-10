package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.GameObject;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;

import java.util.LinkedList;


public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private LinkedList<Target> movingTargets;


    public Game() {

    }

    public void init() {

        field = new Field();
        player = new Player();
        plane = new Plane();
        movingTargets = new LinkedList<>();

    }

    public void start() throws InterruptedException {

        plane.movePlane();

        while (true) {


            Thread.sleep(200);

            moveAllTargets();

            movingTargets.add(TargetFactory.createTarget());
        }

    }


    public void moveAllTargets() {
        for (Target iterator : movingTargets) {
            iterator.moveTarget(field);
        }
    }

}
