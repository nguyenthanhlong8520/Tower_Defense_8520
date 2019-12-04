package Tower;
import Object_In_Game.Monster;
import Singleton.Singleton;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import Singleton.Singleton;

import java.util.List;


public class Tower_1 extends Tower {

    Image bullet = new Image("file:src/AssetsKit/bullet.png");

    public Tower_1() {}

    public Tower_1(double x, double y, double rotate, double range, Group root ) {
        super(x, y, rotate, range, root);
    }

    @Override
    public void Render( GraphicsContext graphicsContext ) {
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
    public void Rotate( double X, double Y, List<Monster> List_Monster) {
        Point2D target = new Point2D(X,Y);
        Point2D tower = new Point2D(x,y);
        Point2D reference = new Point2D(x,0);
        if ( target.distance(tower) < range && X > x ) {
            rotate = tower.angle(target, reference);
            shoot(X,Y , List_Monster);
            Singleton.getInstance().Music_Game_Over();
        }
        else if (target.distance(tower) < range && X < x){
            rotate = -tower.angle(target,reference);
            shoot( X,Y ,List_Monster);
            Singleton.getInstance().Music_Game_Over();
        }
    }

    long time = 0;

    public void shoot(double X, double Y , List<Monster> List_Monster){
        ImageView bullet = new ImageView(this.bullet);
        bullet.setVisible(false);
        Path projectilePath = new Path();
        LineTo lineTo = new LineTo(X , Y);
        bullet.setVisible(true);
        bullet.setFitHeight(32);
        bullet.setFitWidth(32);
        projectilePath.getElements().add(new MoveTo(x, y));
        projectilePath.getElements().add(lineTo);
        PathTransition projectile = new PathTransition();
        projectile.setDuration(Duration.millis(150));
        projectile.setNode(bullet);
        projectile.setPath(projectilePath);
        projectile.setCycleCount(0);
        projectile.setAutoReverse(false);
        if (System.nanoTime() - time > 100000000){
            root.getChildren().add(bullet);
            time = System.nanoTime();
        }
        projectile.setOnFinished(action -> {
            root.getChildren().remove(bullet);
        });projectile.play();
        for ( int i = 0; i < List_Monster.size() ; i++){
            if (List_Monster.get(i).getX() == lineTo.getX()){
                List_Monster.get(i).setHealth(List_Monster.get(i).getHealth() - 1);
                if (List_Monster.get(i).getHealth() == 0){
                    setK(i);
                }
            }
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