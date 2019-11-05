package Object_In_Game;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Object_1 extends Object_In_Game{
    int Toa_do_x ;
    int Toa_do_y ;
    int Speed;
    public Object_1(int toa_do_x, int toa_do_y, int speed) {
        Toa_do_x = toa_do_x;
        Toa_do_y = toa_do_y;
        Speed = speed;
    }
    @Override
    public int getValue_X() {
        return Toa_do_x;
    }
    @Override
    public int getValue_Y() {
        return Toa_do_y;
    }
    @Override
    public int getSpeed() {
        return Speed;
    }

    @Override
    public Image Create_Object(int x) {
        ImageView imageView = new ImageView("file:/home/nguyen/Desktop/Image/231.png"); // xe vang`
        imageView.setRotate(x);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        return rotatedImage;
    }

    @Override
    public Image Create_Health(int x) {
        ImageView imageView = new ImageView("file:/home/nguyen/Desktop/Image/241.png"); // xe vang`
        imageView.setRotate(x);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        //
        return rotatedImage;
    }

}

