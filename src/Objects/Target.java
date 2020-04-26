package Objects;

import Utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Target extends InteractsWithTarget {

    private BufferedImage targetImg;
    private int positionX, positionY;
    private Rectangle rectangle;


    public Target() {
        targetImg = Resources.getResourcesImage("Data/fence.png");
        positionX = 600;
        positionY = 120;
        rectangle = new Rectangle();

    }

    public void update() {
        positionX -= 3;
        rectangle.x = positionX;
        rectangle.y = positionY;
        rectangle.width = targetImg.getWidth();
        rectangle.height = targetImg.getHeight();
    }
    @Override
    public Rectangle getBound() {
        return rectangle;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(targetImg, positionX, positionY, null);

    }
}
