package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.q1.sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;

public class Game {

    private Player player;
    private Plane plane;
    private Field field;
    private LinkedList<Target> movingTargets;

    private int delay = 6;
    private int delayNano = 900001;

    private Picture menu;
    private Picture instructions;
    private Picture gameOver;

    private Sound gameMusic;
    private Sound gameOverSound;
    private Sound ohNoSound;
    private Sound gotcha;
    private Sound crash;

    public void menuLoop() {
        delay = 6;
        delayNano = 900001;
        player = new Player();

        init();

        while (player.isStart()) {
            System.out.println("Press 1");
        }

        System.out.println("1 PRESSED");
        start();
    }

    public void init() {
        menu = new Picture(10, 10, "Menu.png");
        instructions = new Picture(10, 10, "instructions.png");
        gameOver = new Picture(10, 10, "GameOver_800x900.png");

        initGameObjects();
        initSound();
        player.startButton();
        plane.movePlane();
        gameMusic.play(true);
        menu.draw();
    }

    private void initGameObjects() {
        field = new Field();
        plane = new Plane();
        movingTargets = new LinkedList<>();
    }

    private void initSound() {
        gameMusic = new Sound("/Space_Lady.wav");
        gameOverSound = new Sound("/game-over-arcade.wav");
        ohNoSound = new Sound("/oh no sound effect.wav");
        //gotcha = new Sound("Gotcha Bitch.wav");
        crash = new Sound("/crashAsteroid.WAV");

    }

    public void start() {
        try {
            beginning();
            gameLoop();
            gameOver();

            Thread.sleep(1000);

            gameOverStep2();

            Thread.sleep(2000);

            closeAudioStreams();
            player.restartButton();
            System.out.println("Player restart reached");

            while (!player.isRestart()) {
                System.out.println("Are you ready for another round?");
                newGame();
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }

    private void beginning() throws InterruptedException {
        menu.delete();
        instructions.draw();

        Thread.sleep(7000);

        instructions.delete();
        field.draw();
        plane.drawLifePictures();
        plane.setTextScore(player.getScore());
        plane.drawScoreText();
        plane.draw();
        movingTargets.add(TargetFactory.createTarget());
    }

    private void gameLoop() throws InterruptedException {
        while (plane.getLife() != 0) {
            Thread.sleep(delay, delayNano);

            checkErased();
            moveAllTargets();
            checkCollision();

            for (Target target : movingTargets) {
                if (target.targetGetY() == field.getHeight() - 700) {
                    movingTargets.add(TargetFactory.createTarget());
                    break;
                }
            }


        }
    }

    private void gameOver() {
        gameOver.draw();
        plane.deleteScoreText();
        plane.drawLifePictures();
        plane.drawScoreText();
        gameMusic.stop();
        gameOverSound.play(true);
    }

    private void gameOverStep2() {
        gameOverSound.stop();
        ohNoSound.play(true);
    }

    private void closeAudioStreams() {
        ohNoSound.stop();
        //gotcha.close();
        crash.close();
        gameMusic.close();
        gameOverSound.close();
        ohNoSound.close();
    }

    public void checkLife() {
        if (plane.getLife() == 2) {
            plane.deleteScoreText();
            plane.drawLifePictures();
            plane.drawScoreText();
        }

        if (plane.getLife() == 1) {
            plane.deleteScoreText();
            plane.drawLifePictures();
            plane.drawScoreText();
        }
    }

    public void checkErased() {
        for (int i = 0; i < movingTargets.size(); i++) {
            if (movingTargets.get(i).isErased()) {
                movingTargets.remove(i);
                break;
            }
        }
    }

    public void checkCollision() {
        for (Target target : movingTargets) {
            if (plane.collide(target)) {

                if (target instanceof Astronaut) {
                    //gotcha.play(true);
                    plane.deleteScoreText();
                    player.setScore(1);
                    plane.setTextScore(player.getScore());
                    plane.drawScoreText();
                    setNewThreadSleep();
                }

                if (target instanceof Asteroid) {
                    crash.play(true);
                    plane.setLife(1);
                    System.out.println("ACTUAL LIFE: " + plane.getLife());
                    checkLife();
                }

                target.eraseTarget();
                break;
            }
        }
    }

    private void newGame() {
        if (player.isRestart()) {
            gameOver.delete();
            menuLoop();
            player.setRestart();
            player.setStart();
        }
    }

    public void moveAllTargets() {
        for (Target target : movingTargets) {
            target.moveTarget();
        }
    }

    public void setNewThreadSleep() {
        if (delay != 1 || delayNano != 1) {
            if (delayNano == 1) {
                delay--;
                delayNano = 900001;
                return;
            }
            delayNano -= 100000;
        }
    }
}