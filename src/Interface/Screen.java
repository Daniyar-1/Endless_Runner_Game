package Interface;

import Objects.MainCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 0.1F;
    public static final float GROUNDY = 700;

    private MainCharacter mainCharacter ;
    private Thread thread;

    public Screen() {
        setBackground(Color.cyan);
        thread = new Thread(this);
        mainCharacter = new MainCharacter();

    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                mainCharacter.update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException e) {

            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);
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

