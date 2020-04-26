package Objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InteractsManager {
    private List<InteractsWithTarget> enemies;

    public InteractsManager() {
        enemies = new ArrayList<InteractsWithTarget>();

        Target target = new Target();
        enemies.add(target);

    }

    public void update(){
        for ( InteractsWithTarget e : enemies){
            e.update();
        }
    }

    public void draw(Graphics g) {
        for (InteractsWithTarget iwt : enemies) {
            iwt.draw(g);
        }
    }
}
