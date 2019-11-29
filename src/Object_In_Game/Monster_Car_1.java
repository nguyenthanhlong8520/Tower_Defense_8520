package Object_In_Game;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Monster_Car_1 extends Monster{

    public Monster_Car_1(Image image , double x , double y , double Rotate , double Speed , double Health , int Rotate_Blood){
        super(image,x,y,Rotate,Speed,Health,Rotate_Blood);
    }

    @Override
    public void Render(GraphicsContext graphicsContext) {
        ImageView imageView = new ImageView(image); // xe vang`
        imageView.setRotate(Rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        graphicsContext.drawImage(rotatedImage,x,y);
    }

    @Override
    public void Blood_bar(GraphicsContext graphicsContext) {
        ImageView imageView = new ImageView("file:src/AssetsKit/241.png"); // xe vang`
        imageView.setRotate(Rotate_Blood);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        graphicsContext.drawImage(rotatedImage,x+37,y);
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
