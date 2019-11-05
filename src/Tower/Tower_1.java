package Tower;

import javafx.geometry.Point3D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Tower_1 extends Tower{

    public Tower_1(double x, double y) {
        super(x, y);
    }

    @Override
    public Image Create_Tower() {
       Image image = new Image("file:/home/nguyen/Desktop/Image/base.png");
       return image;
    }

    @Override
    public Image Create_Gun(int x) {
        Rotate rotate = new Rotate();

        rotate.setPivotX(100);
        rotate.setPivotY(100);
        rotate.setAngle(90);

        ImageView imageView = new ImageView("file:/home/nguyen/Desktop/Image/gun.png");
        Image image = new Image("file:/home/nguyen/Desktop/Image/gun.png");
        System.out.println(image.getWidth() + " " +image.getHeight());
        System.out.println(imageView.getFitHeight());
        imageView.getTransforms().addAll(rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        return rotatedImage;
    }
}
