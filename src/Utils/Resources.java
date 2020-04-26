package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resources {

    public static BufferedImage getResourcesImage(String p) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;


    }
}
