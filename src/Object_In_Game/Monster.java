package Object_In_Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Monster {

    public Image image;
    public double x = 2000 , y = 2000 , Rotate , Speed , Health;
    public int Rotate_Blood = 90;

    abstract public void Render(GraphicsContext graphicsContext);
    abstract public void Blood_bar(GraphicsContext graphicsContext);
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
