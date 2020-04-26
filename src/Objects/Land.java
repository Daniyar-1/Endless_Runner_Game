package Objects;

import Interface.Screen;
import Utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Land {

    List<ImageLand> LandListImage;
    private BufferedImage land, land2, land3;
    private Random random;

    public Land(Screen screen) {
        random = new Random();
        land = Resources.getResourcesImage("Data/land1.png");
        land2 = Resources.getResourcesImage("Data/land2.png");
        land3 = Resources.getResourcesImage("Data/land3.png");
        LandListImage = new ArrayList<ImageLand>();
        int numOfLand = 600 / land.getWidth() + 2;
        for (int i = 0; i < numOfLand; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.positionX = (int) (i * land.getWidth());
            imageLand.image = getImageLand();
            LandListImage.add(imageLand);
        }
    }

    public void update() {
        for (ImageLand imageLand : LandListImage) {
            imageLand.positionX -= 3;
        }
        ImageLand element = LandListImage.get(0);
        if (LandListImage.get(0).positionX + land.getWidth() < 0) {
            element.positionX = LandListImage.get(LandListImage.size() - 1).positionX + land.getWidth();
            LandListImage.add(LandListImage.get(0));
            LandListImage.remove(0);

        }
    }

    public void draw(Graphics g) {
        for (ImageLand imageLand : LandListImage) {
            g.drawImage(imageLand.image, imageLand.positionX, 136, null);
        }

    }

    private BufferedImage getImageLand() {
        int rm = random.nextInt(5);
        switch (rm) {
            case 0:
                return land;
            case 1:
                return land3;
            default:
                return land2;
        }

    }

    private class ImageLand {
        int positionX;
        BufferedImage image;
    }
}

