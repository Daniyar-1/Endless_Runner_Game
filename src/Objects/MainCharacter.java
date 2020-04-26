package Objects;

import Interface.Screen;
import Utils.Animation;
import Utils.Resources;


import java.awt.*;


public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterRunning;
    private Rectangle rectangle;

    public MainCharacter() {
        characterRunning = new Animation(500);
        characterRunning.addFrame(Resources.getResourcesImage("Data/chicken1.png"));
        characterRunning.addFrame(Resources.getResourcesImage("Data/chicken2.png"));
       /* characterRunning.addFrame(Resources.getResourcesImage("Data/main-character1.png"));
        characterRunning.addFrame(Resources.getResourcesImage("Data/main-character2.png"));*/
        rectangle = new Rectangle();

    }


    public void update() {
        characterRunning.update();
        if (y >= Screen.GROUNDY - characterRunning.getFrame().getHeight()) {
            speedY = 0;
            y = Screen.GROUNDY - characterRunning.getFrame().getHeight();
        } else {
            speedY += Screen.GRAVITY;
            y += speedY;
        }
        rectangle.x = (int) x;
        rectangle.y = (int) y;
        rectangle.width = characterRunning.getFrame().getWidth();
        rectangle.height = characterRunning.getFrame().getHeight();
    }
    public Rectangle getBound(){
        return rectangle;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, characterRunning.getFrame().getWidth(), characterRunning.getFrame().getHeight());
        g.drawImage(characterRunning.getFrame(), (int) x, (int) y, null);
    }

    public void jump() {
        speedY = -4;
        y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
