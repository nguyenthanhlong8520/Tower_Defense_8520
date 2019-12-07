package Tower;
import Object_In_Game.Enemy;
import Object_In_Game.Enemy_Car_Blue;
import Object_In_Game.Enemy_Car_Red;
import Object_In_Game.Enemy_Car_Yellow;
import javafx.animation.PathTransition;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.List;


public class Tower_1 extends Tower {

    Image bullet = new Image("file:src/AssetsKit/bullet.png");
    Image image_tower = new Image("file:src/AssetsKit/Tower.png");
    Image image_base = new Image("file:src/AssetsKit/Base.png");
    Image image_range = new Image("file:src/AssetsKit/Range.png");
    int Damage = 4;

    public Tower_1() {}

    public Tower_1(double x, double y, double rotate, double range, Group root, GraphicsContext graphicsContext ) {
        super(x, y, rotate, range, root,graphicsContext);
    }

    @Override
    public void Render() {
        //
        ImageView imageView = new ImageView(image_tower);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setRotate(rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        //
        graphicsContext.drawImage(image_base, x - 30, y - 30);
        graphicsContext.drawImage(rotatedImage, x - 23, y - 20);
    }

    @Override // X , Y : toa do enemy ; x,y : toa do tower;
    public void Rotate( double X, double Y, List<Enemy> list_Enemy) {
        Point2D target = new Point2D(X,Y);
        Point2D tower = new Point2D(x,y);
        Point2D reference = new Point2D(x,0);
        if ( target.distance(tower) < range && X > x ) {
            rotate = tower.angle(target, reference);
            shoot(X,Y , list_Enemy,rotate );
            graphicsContext.drawImage(image_range, x - 65, y - 65);
        }
        else if (target.distance(tower) < range && X < x){
            rotate = -tower.angle(target,reference);
            shoot( X,Y , list_Enemy,rotate );
            graphicsContext.drawImage(image_range, x - 65, y - 65);
        }
    }

    long time = 0;
    public void shoot(double X, double Y , List<Enemy> list_Enemy, double rotate){
        ImageView bullet = new ImageView(this.bullet);
        bullet.setVisible(true);
        bullet.setX(-1000);
        bullet.setX(-1000);
        bullet.setFitHeight(35);
        bullet.setFitWidth(35);
        Path path = new Path();
        path.getElements().add(new MoveTo(x, y));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(100)); // speed of bullet to target.
        pathTransition.setNode(bullet);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(0);
        pathTransition.setAutoReverse(false);

        for (int i = 0 ; i < list_Enemy.size() ; i++){
            if (list_Enemy.get(i) instanceof Enemy_Car_Red
                    || list_Enemy.get(i) instanceof Enemy_Car_Yellow || list_Enemy.get(i) instanceof Enemy_Car_Blue){
                if (System.nanoTime() - time > 100000000){
                    LineTo lineTo = new LineTo(X , Y);
                    path.getElements().add(lineTo);
                    root.getChildren().add(bullet);
                    try {
                        Music music = new Music();
                        music.PLay_Shoot();
                    }catch (Exception e){}
                    time = System.nanoTime();
                    pathTransition.play();
                    Support_Shoot(list_Enemy,lineTo.getX());
                }
                pathTransition.setOnFinished(action -> {
                    root.getChildren().remove(bullet);
                });
            }
        }
    }

    public void Support_Shoot(List<Enemy> list_Enemy, double x){ //x = lineto.getX;
        for (int i = 0; i < list_Enemy.size() ; i++){
            if (list_Enemy.get(i).getX() == x) {
                list_Enemy.get(i).setHealth(list_Enemy.get(i).getHealth() - getDamage());
                if (list_Enemy.get(i).getHealth() == 0) {
                    setK(i);
                }
            }
        }
    }

    public int getDamage() {
        return Damage;
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