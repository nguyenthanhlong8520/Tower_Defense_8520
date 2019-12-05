package Tower;

import Object_In_Game.Monster;
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

public class Tower_3 extends Tower{

    Image bullet = new Image("file:src/AssetsKit/bullet_rocket_x.png");
    int Dame = 15;

    public Tower_3() {
    }

    public Tower_3(double x, double y, double rotate, double range, Group root) {
        super(x, y, rotate, range, root);
    }

    @Override
    public void Render( GraphicsContext graphicsContext ) {
        Image image = new Image("file:src/AssetsKit/2_Rocket.png");
        Image image1 = new Image("file:src/AssetsKit/Base.png");
        Image image2 = new Image("file:src/AssetsKit/Range.png");
        //
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setRotate(rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        //
        ImageView imageView_range = new ImageView(image2);
        imageView_range.setFitWidth(500);
        imageView_range.setFitHeight(500);
        SnapshotParameters params_range = new SnapshotParameters();
        params_range.setFill(Color.TRANSPARENT);
        Image image_range = imageView_range.snapshot(params_range, null);
        //
        graphicsContext.drawImage(image1, x - 30, y - 30);
        graphicsContext.drawImage(image_range, x - 230, y - 230);
        graphicsContext.drawImage(rotatedImage, x - 23, y - 20);
    }

    @Override // X , Y : toa do enemy ; x,y : toa do tower;
    public void Rotate( double X, double Y, List<Monster> List_Monster) {
        Point2D target = new Point2D(X,Y);
        Point2D tower = new Point2D(x,y);
        Point2D reference = new Point2D(x,0);
        if ( target.distance(tower) < range && X > x ) {
            rotate = tower.angle(target, reference);
            shoot(X,Y , List_Monster,rotate);
        }
        else if (target.distance(tower) < range && X < x){
            rotate = -tower.angle(target,reference);
            shoot( X,Y ,List_Monster,rotate);
        }
    }

    long time = 0;

    public void shoot(double X, double Y , List<Monster> List_Monster ,double rotate){
        ImageView bullet = new ImageView(this.bullet);
        bullet.setVisible(false);
        bullet.setVisible(true);
        bullet.setX(-1000);
        bullet.setX(-1000);
        bullet.setFitHeight(45);
        bullet.setFitWidth(45);
        bullet.setRotate(rotate - 70);

        Path path = new Path();
        path.getElements().addAll(new MoveTo(x, y));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(150));
        pathTransition.setNode(bullet);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(0);
        pathTransition.setAutoReverse(false);

        if (System.nanoTime() - time > 1000000000){
            LineTo lineTo = new LineTo(X , Y);
            path.getElements().add(lineTo);
            root.getChildren().add(bullet);
            try {
                Music music = new Music();
                music.PLay_Shoot();
            }catch (Exception e){ }
            time = System.nanoTime();
            pathTransition.play();
            Support_Shoot(List_Monster,lineTo.getX());
        }
        pathTransition.setOnFinished(action -> {
            root.getChildren().remove(bullet);
        });
    }

    public void Support_Shoot(List<Monster> List_Monster , double x){ //x = lineto.getX;
        for ( int i = 0; i < List_Monster.size() ; i++){
            if (List_Monster.get(i).getX() == x) {
                List_Monster.get(i).setHealth(List_Monster.get(i).getHealth() - getDame());
                if (List_Monster.get(i).getHealth() == 0) {
                    setK(i);
                }
            }
        }
    }

    public int getDame() {
        return Dame;
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
