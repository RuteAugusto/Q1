package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private LinkedList<Target> movingTargets;

    private Picture gameOver;
    private Picture zeroLives;
    private Picture oneLife;
    private Picture twoLives;
    private Picture threeLives;

    public Game() {

    }

    public void init() {

        field = new Field();
        player = new Player();
        plane = new Plane();
        movingTargets = new LinkedList<>();

        threeLives = new Picture(10,10,"3lives.png");
        twoLives = new Picture(10,10, "2lives.png");
        oneLife = new Picture(10,10,"1life.png");
        gameOver = new Picture(10, 10, "GameOver_800x900.png");
        zeroLives = new Picture(10,10, "0life.png");
    }

    public void start() throws InterruptedException {

        plane.movePlane();

        movingTargets.add(TargetFactory.createTarget());

        while (plane.getLife() != 0) {

            Thread.sleep(5);

            checkErased();

            moveAllTargets();

            checkCollision();

            if (movingTargets.peekLast().targetGetY() == field.getHeigth() - 700) {
                movingTargets.add(TargetFactory.createTarget());
            }
        }

        System.out.println("Game Over");
        gameOver.draw();
        zeroLives.draw();
    }

    public void checkLife(){

        if(plane.getLife() == 3){
            threeLives.draw();
        }

        if(plane.getLife() == 2){
            System.out.println("teste");
            twoLives.draw();
        }

        if(plane.getLife() == 1){
            oneLife.draw();
        }
    }

    public void checkErased() {

        for (int i = 0; i < movingTargets.size(); i++) {
            if (movingTargets.get(i).isErased()) {
                movingTargets.remove();
            }
        }
    }


    public void moveAllTargets() {
        for (Target iterator : movingTargets) {
            iterator.moveTarget();
        }
    }

    public void checkCollision() {
        for (Target iterator : movingTargets) {

            if (plane.collide(iterator)) {

                System.out.println("CRASH");


                if (iterator instanceof Astronaut) {
                    player.setScore(10);
                    System.out.println(player.getScore());
                }

                if (iterator instanceof Asteroid) {
                    plane.setLife(1);
                    System.out.println("ACTUAL LIFE: " + plane.getLife());
                    checkLife();
                   // System.out.println("rhkgjhkjfgk");
                }

                iterator.eraseTarget();
                break;
            }
        }
    }
}
