package Tower;

import javafx.scene.image.Image;

public abstract class Tower {
    Image gun;
    Image base;
    double X , Y;

    public Tower(double x, double y) {
        X = x;
        Y = y;
    }

    public abstract Image Create_Tower();
    public abstract Image Create_Gun(int x);
}
