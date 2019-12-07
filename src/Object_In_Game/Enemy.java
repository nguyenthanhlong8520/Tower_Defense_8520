package Object_In_Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public abstract class Enemy {

    protected Image image;
    protected double x , y , Rotate , Speed , Health;
    protected int Rotate_Blood ;
    protected GraphicsContext graphicsContext;

    public Enemy(Image image, double x, double y, double rotate, double speed, double health, int rotate_blood , GraphicsContext graphicsContext) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.Rotate = rotate;
        this.Speed = speed;
        this.Health = health;
        this.Rotate_Blood = rotate_blood;
        this.graphicsContext = graphicsContext;
    }

    public  double getHealth() {
        return Health;
    }
    public void setHealth(double health) {
        Health = health;
    }

    abstract public void Render();
    abstract public void Blood_bar(List<Enemy> list_Enemy);
    abstract public void Move_Up();
    abstract public void Move_Down();
    abstract public void Move_Left();
    abstract public void Move_Right();
    abstract public void Rotate();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRotate(double rotate) {
        Rotate = rotate;
    }

}
