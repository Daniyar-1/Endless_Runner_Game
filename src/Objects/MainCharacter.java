package Objects;

import Interface.Screen;
import Utils.Animation;
import Utils.Resources;


import java.awt.*;


public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterFlying;

    public MainCharacter() {
        characterFlying = new Animation(500);
        characterFlying.addFrame(Resources.getResourcesImage("Data/main-character1.png"));
        characterFlying.addFrame(Resources.getResourcesImage("Data/main-character2.png"));

    }


    public void update() {
        characterFlying.update();
        if (y >= Screen.GROUNDY - characterFlying.getFrame().getHeight()) {
            speedY = 0;
            y = Screen.GROUNDY - characterFlying.getFrame().getHeight();
        } else {
            speedY += Screen.GRAVITY;
            y += speedY;

        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, characterFlying.getFrame().getWidth(), characterFlying.getFrame().getHeight());
        g.drawImage(characterFlying.getFrame(),(int ) x,(int ) y, null);
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
