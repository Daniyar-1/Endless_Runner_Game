package Objects;

import Interface.Screen;
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
    private Screen screen;


    public InteractsManager(Chicken chicken, Screen screen) {
        this.screen = screen;
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
            if (e.isOver() && !e.isScoreGot()){
                screen.addingScore(20);
                e.setScoreGot(true);
            }
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
    public void reset(){
        enemies.clear();
        enemies.add(getRandomTarget());
    }

    private Target getRandomTarget() {
        Target tg;
        tg = new Target(chicken);
        tg.setPositionX(600);
        if (random.nextBoolean()) {
            tg.setImage(fenceImg1);
        } else {
            tg.setImage(fenceImg2);
        }
        return tg;
    }

}
