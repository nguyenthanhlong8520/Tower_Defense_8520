package Tower;

import javafx.scene.canvas.GraphicsContext;

public abstract class Tower {

    protected double x, y; // toa do keo tha tru;
    protected double rotate ;
    protected double range ; // tam ban cua tru

    public Tower(double x, double y, double rotate, double range) {
        this.x = x;
        this.y = y;
        this.rotate = rotate;
        this.range = range;
    }

    public abstract void Render(GraphicsContext graphicsContext);
    public abstract void Rotate(double x, double y, GraphicsContext graphicsContext);

    public abstract double getX();
    public abstract double getY();
    public abstract double getRange();
}
