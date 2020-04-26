package Objects;

import java.awt.*;

public abstract class InteractsWithTarget {

    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();

}
