package Interface;

import Objects.Clouds;
import Objects.Land;
import Objects.MainCharacter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screen extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 0.1F;
    public static final float GROUNDY = 152;

    private MainCharacter mainCharacter;
    private Thread thread;
    private BufferedImage background;
    private Land land;
    private Clouds clouds;

    public Screen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50);
        land = new Land(this);
        clouds = new Clouds();
    }

    public void startGame() {
        thread.start();
    }


    @Override
    public void run() {
        while (true) {
            try {
                mainCharacter.update();
                clouds.update();
                land.update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException e) {

            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);
        land.draw(g);
        clouds.draw(g);
        mainCharacter.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        mainCharacter.jump();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}

