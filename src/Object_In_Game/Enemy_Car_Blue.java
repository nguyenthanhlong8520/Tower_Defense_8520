package Object_In_Game;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;

public class Enemy_Car_Blue extends Enemy {

    public Enemy_Car_Blue(Image image, double x, double y, double rotate, double speed, double health, int rotate_blood, GraphicsContext graphicsContext) {
        super(image, x, y, rotate, speed, health, rotate_blood, graphicsContext);
    }

    @Override
    public void Render() {
        ImageView imageView = new ImageView(image); // xe vang`
        imageView.setRotate(Rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        graphicsContext.drawImage(rotatedImage,x,y);
    }

    @Override
    public void Blood_bar(List<Enemy> list_Enemy) {
        ImageView imageView5 = new ImageView("file:src/AssetsKit/min6.png"); // xe vang`
        imageView5.setRotate(Rotate_Blood);
        SnapshotParameters params5 = new SnapshotParameters();
        params5.setFill(Color.TRANSPARENT);
        Image rotatedImage5 = imageView5.snapshot(params5, null);

        ImageView imageView4 = new ImageView("file:src/AssetsKit/min5.png"); // xe vang`
        imageView4.setRotate(Rotate_Blood);
        SnapshotParameters params4 = new SnapshotParameters();
        params4.setFill(Color.TRANSPARENT);
        Image rotatedImage4 = imageView4.snapshot(params4, null);

        ImageView imageView3 = new ImageView("file:src/AssetsKit/min4.png"); // xe vang`
        imageView3.setRotate(Rotate_Blood);
        SnapshotParameters params3 = new SnapshotParameters();
        params3.setFill(Color.TRANSPARENT);
        Image rotatedImage3 = imageView3.snapshot(params3, null);

        ImageView imageView2 = new ImageView("file:src/AssetsKit/min3.png"); // xe vang`
        imageView2.setRotate(Rotate_Blood);
        SnapshotParameters params2 = new SnapshotParameters();
        params2.setFill(Color.TRANSPARENT);
        Image rotatedImage2 = imageView2.snapshot(params2, null);

        ImageView imageView1 = new ImageView("file:src/AssetsKit/min2.png"); // xe vang`
        imageView1.setRotate(Rotate_Blood);
        SnapshotParameters params1 = new SnapshotParameters();
        params1.setFill(Color.TRANSPARENT);
        Image rotatedImage1 = imageView1.snapshot(params1, null);

        for (int i = 0; i < list_Enemy.size() ; i++){
            if (list_Enemy.get(i).getHealth() > 100 && list_Enemy.get(i).getHealth() < 150){
                graphicsContext.drawImage(rotatedImage5,x+37,y);
            }
            else if (list_Enemy.get(i).getHealth() > 80 && list_Enemy.get(i).getHealth() < 100){
                graphicsContext.drawImage(rotatedImage4,x+37,y);
            }
            else if (list_Enemy.get(i).getHealth() > 60 && list_Enemy.get(i).getHealth() < 80){
                graphicsContext.drawImage(rotatedImage3,x+37,y);
            }
            else if (list_Enemy.get(i).getHealth() > 40 && list_Enemy.get(i).getHealth() < 60 ){
                graphicsContext.drawImage(rotatedImage2,x+37,y);
            }
            else if (list_Enemy.get(i).getHealth() > 20 && list_Enemy.get(i).getHealth() < 40 ){
                graphicsContext.drawImage(rotatedImage1,x+37,y);
            }
        }
    }



    @Override
    public void Move_Up() {
        y -= Speed; }
    @Override
    public void Move_Down() {
        y += Speed;
    }
    @Override
    public void Move_Left() {
        x -= Speed;
    }
    @Override
    public void Move_Right() {
        x += Speed;
    }

    @Override
    public void Rotate() {
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getRotate() {
        return Rotate;
    }
    public void setRotate(int Rotate){
        this.Rotate = Rotate;
    }
    public double getSpeed() {
        return Speed;
    }
    public void setSpeed(double speed) {
        Speed = speed;
    }
}
