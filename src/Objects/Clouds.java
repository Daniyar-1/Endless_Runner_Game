package Objects;

import Utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds {

    private BufferedImage cloudImg;
    private List<Cloud> cloudsList;
    private Random random;

    public Clouds() {
        cloudImg = Resources.getResourcesImage("Data/cloud.png");
        cloudsList = new ArrayList<Cloud>();

        random = new Random();

        Cloud cloud1 = new Cloud();
        cloud1.positionX = 100;
        cloud1.positionY = 30;
        cloudsList.add(cloud1);

        Cloud cloud2 = new Cloud();
        cloud2.positionX = 250;
        cloud2.positionY = 60;
        cloudsList.add(cloud2);

        Cloud cloud3 = new Cloud();
        cloud3.positionX = 450;
        cloud3.positionY = 10;
        cloudsList.add(cloud3);

        Cloud cloud4 = new Cloud();
        cloud4.positionX = 600;
        cloud4.positionY = 80;
        cloudsList.add(cloud4);
    }

    public void update() {
        for (Cloud cloud : cloudsList) {
            cloud.positionX--;
        }
        Cloud firstCloud = cloudsList.get(0);
        if (firstCloud.positionX + cloudImg.getWidth() < 0) {
            firstCloud.positionX = 600;
            cloudsList.remove(firstCloud);
            cloudsList.add(firstCloud);        }
    }

    public void draw(Graphics g) {
        for (Cloud cloud : cloudsList) {
            g.drawImage(cloudImg, (int) cloud.positionX, (int) cloud.positionY, null);
        }
    }

    private class Cloud {
        float positionX;
        float positionY;
    }
}

