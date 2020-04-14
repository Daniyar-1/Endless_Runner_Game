package Interface;

import javax.swing.*;


class Window extends JFrame {
    private Screen screen;

    public Window() {
        super("Endless Runner 1.0");
        setSize(1024, 768);
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
    }

}

