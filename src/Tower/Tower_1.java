package Tower;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Tower_1 extends Tower {
    public double x , y;
    double rotate = 0;
    @Override
    public void Render(GraphicsContext graphicsContext) {
        Image image = new Image("file:/home/nguyen/Desktop/Image/Tower.png");
        Image image1 = new Image("file:/home/nguyen/Desktop/Image/Base.png");
        ImageView imageView = new ImageView(image); // xe vang`
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setRotate(rotate);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = imageView.snapshot(params, null);
        graphicsContext.drawImage(image1,x-30,y-30 );
        graphicsContext.drawImage(rotatedImage,x-23,y-20);
    }
    @Override
    public void Rotate() {
        rotate += 3;
    }
}
