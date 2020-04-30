package Objects;

import java.awt.*;

public abstract class InteractsWithTarget {

    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isOutOfScreen();
    public abstract boolean isOver();
    public abstract boolean isScoreGot();
    public abstract void setScoreGot(boolean isScoreGot);

}
