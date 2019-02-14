package org.academiadecodigo.q1;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private int score;
    private String scoreString;
    private Text scoreText;
    private boolean start = true;
    private boolean restart;

    public void startButton() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_1);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);
    }

    public void restartButton() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KeyboardEvent.KEY_SPACE);
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restart);
    }

    public void drawScoreText() {
        scoreText.draw();
    }

    public void deleteScoreText() {
        scoreText.delete();
    }

    public boolean isStart() {
        return start;
    }

    public void setStart() {
        this.start = true;
    }

    public boolean isRestart() {
        return restart;
    }

    public void setRestart() {
        this.restart = false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setTextScore(int playerScore) {
        scoreString = String.valueOf(playerScore);

        scoreText = new Text(700, 60, scoreString);
        scoreText.setColor(Color.WHITE);
        scoreText.grow(15, 20);
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_1:
                System.out.println("Key 1 pressed");
                start = false;
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("Space pressed");
                restart = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
