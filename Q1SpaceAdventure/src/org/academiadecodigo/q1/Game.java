package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.GameObject;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.LinkedList;


public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private LinkedList<Target> movingTargets;
    private int score;


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

        movingTargets.add(TargetFactory.createTarget());

        while (true) {


            Thread.sleep(50);

            checkErased();

            moveAllTargets();

            checkCollision();

            if (movingTargets.peekLast().targetGetY() == field.getHeigth() - 700) {
                movingTargets.add(TargetFactory.createTarget());
            }


        }
    }

    public void checkErased() {

        for(int i = 0; i < movingTargets.size(); i++) {
            if (movingTargets.get(i).isErased()) {
                movingTargets.remove();
            }
        }
    }

    public void checkScore() {
        Text score = new Text(100, 100, "teste");
    }


    public void moveAllTargets() {
        for (Target iterator : movingTargets) {
            iterator.moveTarget();
        }
    }

    public void checkCollision() {
        for (Target iterator : movingTargets) {

            if ((plane.getPlaneRect().getX() - iterator.getRect().getX() < (iterator.getRect().getWidth() + plane.getPlaneRect().getWidth()) ) &&
                ((plane.getPlaneRect().getX() - iterator.getRect().getX()) > - (iterator.getRect().getWidth() + plane.getPlaneRect().getWidth())) &&

                ((plane.getPlaneRect().getY() - iterator.getRect().getY()) < iterator.getRect().getWidth()) &&
                ((plane.getPlaneRect().getY() - iterator.getRect().getY()) > - iterator.getRect().getWidth())) {

                System.out.println("CRASH");
                if (iterator instanceof Astronaut) {
                    score += 10;
                    System.out.println(score);
                }
                iterator.eraseTarget();

                break;
            }


        }
    }

    /*
    public boolean getXRange() {
        if ((plane.getPlaneRect().getX() - target.getX) < 60
                && (plane.getPlaneRect().getX() - target.getTargetX()) > -60) {
            return true;
        }
        return false;


    }

    public boolean getYRange() {
        if ((plane.getPlaneRect().getY() - target.getTargetY()) < 60
                && (plane.getPlaneRect().getY() - target.getTargetY()) > -60) {
            return true;
        }
        return false;


    }

    if (getYRange() && getXRange()) {
        System.out.println("CRASH");
        iterator.eraseTarget();
        break;
    }
    */
}
