package org.academiadecodigo.q1;

import org.academiadecodigo.q1.Field.Field;
import org.academiadecodigo.q1.gameobjects.Plane.Plane;
import org.academiadecodigo.q1.gameobjects.hitTarget.Asteroid;
import org.academiadecodigo.q1.gameobjects.hitTarget.Target;
import org.academiadecodigo.q1.gameobjects.hitTarget.TargetFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

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

        movingTargets.add(TargetFactory.createTarget());

        while (plane.getLife() != 0) {


            Thread.sleep(10);

            checkErased();

            moveAllTargets();

            checkCollision();

            if (movingTargets.peekLast().targetGetY() == field.getHeigth() - 700) {
                movingTargets.add(TargetFactory.createTarget());
            }

            checkScore();

        }

        System.out.println("GAME OVER!");
    }

    public void checkErased() {

        for(int i = 0; i < movingTargets.size(); i++) {
            if (movingTargets.get(i).isErased()) {
                movingTargets.remove();
            }
        }
    }

    public void checkScore() { // TODO: 2019-02-10  "improve graphics"
        int valueOfScore = player.getScore();
        Text score = new Text(100, 100, String.valueOf(valueOfScore));
        score.setColor(Color.WHITE);
        score.draw();
    }


    public void moveAllTargets() {
        for (Target iterator : movingTargets) {
            iterator.moveTarget();
        }
    }

    public void checkCollision() {
        for (Target iterator : movingTargets) {


            if ((plane.getPlaneRect().getX() - iterator.getRect().getX() < (iterator.getRect().getWidth() + plane.getRect().getWidth()) ) &&
                ((plane.getRect().getX() - iterator.getRect().getX()) > - (iterator.getRect().getWidth() + plane.getRect().getWidth())) &&

                ((plane.getRect().getY() - iterator.getRect().getY()) < iterator.getRect().getHeight()) &&
                ((plane.getRect().getY() - iterator.getRect().getY()) > - iterator.getRect().getHeight())) {

                System.out.println("CRASH");

                //System.out.println(plane.getPlaneRect().getX() + " " +  iterator.getRect().getX() + " " + iterator.getRect().getWidth() + " " + plane.getPlaneRect().getWidth());
                //System.out.println(plane.getPlaneRect().getY() + " " +  iterator.getRect().getY() + " " + iterator.getRect().getHeight() + " " + plane.getPlaneRect().getHeight());
                if (iterator instanceof Astronaut) { // TODO: 2019-02-10 "improve graphics"
                    player.setScore(10);
                    System.out.println(player.getScore());
                }

                if (iterator instanceof Asteroid) {
                    plane.setDamage(50);
                    System.out.println("ACTUAL DAMAGE: " + plane.getDamage());
                    System.out.println("ACTUAL LIFE: " + plane.getLife());
                }


                iterator.eraseTarget();

                break;
            }
        }
    }
}
