package org.academiadecodigo.q1;

public class Player {

    //private String name;
    private int score;


    public Player () {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
}
