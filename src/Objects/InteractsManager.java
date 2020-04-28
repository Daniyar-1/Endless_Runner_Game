package Objects;

import Utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteractsManager {

    private List<InteractsWithTarget> enemies;
    private Random random;
    private BufferedImage fenceImg1, fenceImg2;
    private Chicken chicken;


    public InteractsManager(Chicken chicken) {
        this.chicken = chicken;
        enemies = new ArrayList<InteractsWithTarget>();
        fenceImg1 = Resources.getResourcesImage("Data/fence.png");
        fenceImg2 = Resources.getResourcesImage("Data/fence2.png");

        random = new Random();
        enemies.add(getRandomTarget());


    }

    public void update() {
        for (InteractsWithTarget e : enemies) {
            e.update();
            if (e.getBound().intersects(chicken.getBound())){
                chicken.setAlive(false);
            }
        }
        InteractsWithTarget iwt = enemies.get(0);
        if (iwt.isOutOfScreen()) {
            enemies.remove(iwt);
            enemies.add(getRandomTarget());
        }
    }

    public void draw(Graphics g) {
        for (InteractsWithTarget iwt : enemies) {
            iwt.draw(g);

        }
    }

    private Target getRandomTarget() {
        Target tg;
        tg = new Target();
        tg.setPositionX(600);
        if (random.nextBoolean()) {
            tg.setImage(fenceImg1);
        } else {
            tg.setImage(fenceImg2);
        }
        return tg;
    }

}
