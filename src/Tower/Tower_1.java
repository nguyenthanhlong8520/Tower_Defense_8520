package Tower;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
;import java.util.ArrayList;
import java.util.List;

public class Tower_1 extends Tower {

    public Tower_1(double x, double y, double rotate, double range) {
        super(x, y, rotate, range);
    }

    @Override
    public void Render(GraphicsContext graphicsContext) {
        Image image = new Image("file:src/AssetsKit/Tower.png");
        Image image1 = new Image("file:src/AssetsKit/Base.png");
        //
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setRotate(rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        //
        graphicsContext.drawImage(image1, x - 30, y - 30);
        graphicsContext.drawImage(rotatedImage, x - 23, y - 20);
    }

    @Override // X , Y : toa do enemy ; x,y : toa do tower;
    public void Rotate(double X, double Y , GraphicsContext graphicsContext) {
        Point2D target = new Point2D(X,Y);
        Point2D tower = new Point2D(x,y);
        Point2D reference = new Point2D(x,0);
        if (target.distance(tower) <= range && X > x) {
            rotate = tower.angle(target, reference);
        }
        else if (target.distance(tower) <= range && X < x){
            rotate = -tower.angle(target,reference);
        }
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    @Override
    public double getRange() {
        return range;
    }
    public void setY(double y) {
        this.y = y;
    }

}