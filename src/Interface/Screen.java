package Interface;

import Common.Configuration;
import Common.Score;
import Objects.*;
import Utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Screen extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 0.1F;
    public static final float GROUNDY = 155;
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;

    private Chicken chicken;
    private Thread thread;
    private BufferedImage background;
    private Land land;
    private Clouds clouds;
    private InteractsManager interManager;
    private BufferedImage gameOverImg;
    private int score;
    private int highestscore;

    private int gameState = GAME_FIRST_STATE;


    public Screen() {
        highestscore = Configuration.getInstance().getHighScore();
        thread = new Thread(this);
        chicken = new Chicken();
        chicken.setX(50);
        chicken.setY(110);
        land = new Land(this);
        clouds = new Clouds();
        interManager = new InteractsManager(chicken, this);
        gameOverImg = Resources.getResourcesImage("Data/game-over.png");
    }

    public void startGame() {
        thread.start();
    }


    @Override
    public void run() {
        while (true) {
            try {
                update();
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

    public void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                chicken.update();
                clouds.update();
                land.update();
                interManager.update();
                if (!chicken.getAlive()) {
                    gameState = GAME_OVER_STATE;
                }
                break;
        }
    }

    public void addingScore(int score) {
        this.score += score;
    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);

        switch (gameState) {
            case GAME_FIRST_STATE:
                chicken.draw(g);
                g.drawString("Press SPACE to start", 230, 30);
                break;
            case GAME_PLAY_STATE:
                land.draw(g);
                clouds.draw(g);
                chicken.draw(g);
                interManager.draw(g);
                g.drawString("Score: " + String.valueOf(score), 500, 40);
                g.drawString("Highest Score: " + String.valueOf(highestscore), 458, 20);
                break;
            case GAME_OVER_STATE:
                land.draw(g);
                chicken.draw(g);
                interManager.draw(g);
                g.drawImage(gameOverImg, 230, 0, null);
                break;
        }

    }

    private void resetGame() {
        chicken.setAlive(true);
        chicken.setX(50);
        chicken.setY(110);
        interManager.reset();
        score = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE: {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE) {
                    gameState = GAME_PLAY_STATE;
                } else if (gameState == GAME_PLAY_STATE) {
                    chicken.jump();
                } else if (gameState == GAME_OVER_STATE) {
                    if(score > highestscore) {
                        highestscore = score;
                        Configuration.getInstance().saveGameHighScore(highestscore);
                    }
                    resetGame();
                    gameState = GAME_PLAY_STATE;
                }
                break;
        }
    }
}

