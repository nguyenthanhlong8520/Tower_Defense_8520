package Tower;

import Object_In_Game.Monster;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Tower {

    protected double x, y ; // toa do keo tha tru;
    protected double rotate ;
    protected double range ; // tam ban cua tru
    public Group root;
    int k; // chi so tra ve de delete Object
    public Tower() {
    }

    public Tower(double x, double y, double rotate, double range, Group root) {
        this.x = x;
        this.y = y;
        this.rotate = rotate;
        this.range = range;
        this.root = root;
    }

    public abstract void Render(GraphicsContext graphicsContext);
    public abstract void Rotate(double x, double y, List<Monster> List_Monster );
    public abstract void shoot(double X, double Y, List<Monster> List_Monster , double rotate);


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
