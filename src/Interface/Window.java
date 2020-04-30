package Interface;

import Common.Configuration;
import Common.Score;

import javax.swing.*;


class Window extends JFrame {
    private Screen screen;

    public Window() {
        super("Endless Runner 1.0");
        setSize(600, 202);
        setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        screen = new Screen();
        add(screen);
        addKeyListener(screen);
    }

    public void startGame(){
        screen.startGame();
    }

    public static void main(String[] args) {

      Window window =  new Window();
      window.setVisible(true);
      window.startGame();
      Screen screen = new Screen();
    }

}

