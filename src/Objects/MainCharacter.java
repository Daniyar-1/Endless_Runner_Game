package Objects;

import Interface.Screen;


import java.awt.*;


public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;



    public void update(){
        if (y >= Screen.GROUNDY - 100) {
            speedY = 0;
            y = Screen.GROUNDY - 100;
        } else {
            speedY += Screen.GRAVITY;
            y += speedY;

        }
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);

        g.drawRect((int) x, (int) y, 100, 100);
    }

    public void jump(){
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
