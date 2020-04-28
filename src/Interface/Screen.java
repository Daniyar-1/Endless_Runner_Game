package Interface;

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

    private int gameState = GAME_FIRST_STATE;


    public Screen() {
        thread = new Thread(this);
        chicken = new Chicken();
        chicken.setX(50);
        land = new Land(this);
        clouds = new Clouds();
        interManager = new InteractsManager(chicken);
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
                Thread.sleep(20);
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

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);

        switch (gameState) {
            case GAME_FIRST_STATE:
                chicken.draw(g);
                break;
            case GAME_PLAY_STATE:
                land.draw(g);
                clouds.draw(g);
                chicken.draw(g);
                interManager.draw(g);
                break;
            case GAME_OVER_STATE:
                land.draw(g);
                chicken.draw(g);
                interManager.draw(g);
                g.drawImage(gameOverImg, 230, 0, null);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
      /*  switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE: {*/
        /*    }*/
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
                    gameState = GAME_PLAY_STATE;
                }
                break;
        }
    }
}

