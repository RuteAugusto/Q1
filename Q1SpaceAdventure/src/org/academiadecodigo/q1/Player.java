package org.academiadecodigo.q1;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private int score;
    private boolean restart;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }


    public void restart() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KeyboardEvent.KEY_SPACE);
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restart);
    }

    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                System.out.println("Space pressed");
                restart = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isRestart() {
        return restart;
    }

    public void setRestart() {
        this.restart = false;
    }
}
