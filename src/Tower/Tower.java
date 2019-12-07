package Tower;

import Object_In_Game.Enemy;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Tower {

    protected double x, y ; // toa do keo tha tru;
    protected double rotate ;
    protected double range ; // tam ban cua tru
    protected Group root;
    int k; // chi so tra ve de delete Object
    GraphicsContext graphicsContext;
    public Tower() {
    }

    public Tower(double x, double y, double rotate, double range, Group root , GraphicsContext graphicsContext) {
        this.x = x;
        this.y = y;
        this.rotate = rotate;
        this.range = range;
        this.root = root;
        this.graphicsContext = graphicsContext;
    }

    public abstract void Render();
    public abstract void Rotate(double x, double y, List<Enemy> list_Enemy);
    public abstract void shoot(double X, double Y, List<Enemy> list_Enemy, double rotate);


    public int getK() {
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
    public abstract double getX();
    public abstract double getY();
    public abstract double getRange();

}
