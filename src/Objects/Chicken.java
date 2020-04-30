package Objects;

import Interface.Screen;
import Utils.Animation;
import Utils.Resources;


import java.awt.*;
import java.awt.image.BufferedImage;


public class Chicken {
    public static final int NORMAL_RUN = 0;
    public static final int JUMPING = 1;

    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterRunning;
    private Rectangle rectangle;
    private boolean isAlive = true;

    private BufferedImage jumping;
    /*private int state = NORMAL_RUN;*/

    public Chicken() {
        characterRunning = new Animation(500);
        characterRunning.addFrame(Resources.getResourcesImage("Data/chicken1.png"));
        characterRunning.addFrame(Resources.getResourcesImage("Data/chicken2.png"));
//        jumping = Resources.getResourcesImage("Data/jumping.png");
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

    public void jump() {
        if (y < 80) {
            speedY = 0;
        } else {
            speedY = -4;
            y += speedY;
            /*state = JUMPING;*/
        }}

        public Rectangle getBound () {
            return rectangle;
        }

        public void draw (Graphics g){
      /*  switch (state) {
            case NORMAL_RUN:*/
            g.drawImage(characterRunning.getFrame(), (int) x, (int) y, null);
//                break;
          /*  case JUMPING:
                g.drawImage(jumping, (int) x, (int) y, null);
                break;
        }*/
        }


        public float getX () {
            return x;
        }

        public void setX ( float x){
            this.x = x;
        }

        public float getY () {
            return y;
        }

        public void setY ( float y){
            this.y = y;
        }

        public float getSpeedY () {
            return speedY;
        }

        public void setSpeedY ( float speedY){
            this.speedY = speedY;
        }

        public void setAlive ( boolean alive){
            isAlive = alive;
        }

        public boolean getAlive () {
            return isAlive;
        }
    }
