package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.q1.sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.LinkedList;


public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private LinkedList<Target> movingTargets;
    private int delay;
    private int delayNano;

    private Text text;
    private String score;

    private Picture menu;
    private Picture instructions;
    private Picture zeroLives;
    private Picture oneLife;
    private Picture twoLives;
    private Picture threeLives;
    private Picture gameOver;

    private Sound gameMusic;
    private Sound gameOverSound;
    private Sound ohNoSound;

    public Game(int delay, int delayNano) {
        this.delay = delay;
        this.delayNano = delayNano;
    }

    public void init() {

        menu = new Picture(10, 10, "Menu.png");

        instructions = new Picture(10, 10, "Instructions.png");


        field = new Field();
        player = new Player();
        plane = new Plane();
        movingTargets = new LinkedList<>();


        score = String.valueOf(player.getScore());
        text = new Text(700, 100, score);
        text.setColor(Color.WHITE);
        text.grow(25,25);

        threeLives = new Picture(10, 10, "3lives.png");
        twoLives = new Picture(10, 10, "2lives.png");
        oneLife = new Picture(10, 10, "1life.png");
        gameOver = new Picture(10, 10, "GameOver_800x900.png");
        zeroLives = new Picture(10, 10, "0life.png");

        gameMusic = new Sound("/Space_Lady.wav");
        gameOverSound = new Sound("/game-over-arcade.wav");
        ohNoSound = new Sound("/oh no sound effect.wav");

        plane.movePlane();

        menu.draw();
    }

    public void start() throws InterruptedException {

        gameMusic.play(true);

        Thread.sleep(1000);

        menu.delete();

        instructions.draw();

        Thread.sleep(1000);

        instructions.delete();

        threeLives.draw();

        text.draw();



        movingTargets.add(TargetFactory.createTarget());

        while (plane.getLife() != 0) {

            Thread.sleep(delay, delayNano);

            checkErased();

            moveAllTargets();

            checkCollision();

            if (movingTargets.peekLast().targetGetY() == field.getHeigth() - 700) {
                movingTargets.add(TargetFactory.createTarget());
            }
        }

        gameOver.draw();

        text.delete();
        zeroLives.draw();
        text.draw();

        gameMusic.stop();
        gameMusic.close();
        gameOverSound.play(true);
        Thread.sleep(1000);
        gameOverSound.stop();
        gameOverSound.close();
        ohNoSound.play(true);
        Thread.sleep(5000);
        ohNoSound.stop();
        ohNoSound.close();

        player.restart();
        while (!player.isRestart()) {
            System.out.println("sfddsdf");
            newGame();
        }

    }

    public void checkLife() {

        if (plane.getLife() == 2) {
            text.delete();
            twoLives.draw();
            text.draw();
        }

        if (plane.getLife() == 1) {
            text.delete();
            oneLife.draw();
            text.draw();
        }
    }

    public void checkErased() {

        for (int i = 0; i < movingTargets.size(); i++) {
            if (movingTargets.get(i).isErased()) {
                movingTargets.remove();
            }
        }
    }

    private void newGame() throws InterruptedException {
        if (player.isRestart()) {
            plane.setLife(-3);
            gameOver.delete();
            start();
            player.setRestart();

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
                    text.delete();
                    player.setScore(1);
                    score = String.valueOf(player.getScore());
                    text = new Text(700, 75, score);
                    text.setColor(Color.WHITE);
                    text.grow(25,25);
                    text.draw();

                    System.out.println(player.getScore());
                    System.out.println(delay + ", " + delayNano);
                    if (delayNano == 1) {
                        delay--;
                        delayNano = 900001;
                        continue;
                    }
                    delayNano -= 100000;
                    //rescued++;

                }

                if (iterator instanceof Asteroid) {
                    plane.setLife(1);
                    System.out.println("ACTUAL LIFE: " + plane.getLife());
                    checkLife();
                }

                iterator.eraseTarget();
                break;
            }
        }
    }
}
