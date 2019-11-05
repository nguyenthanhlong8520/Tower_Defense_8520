// Việc lấy ảnh sẽ đc thực hiện ở đây , và trả về ảnh .

package ImageInButton;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateLinkImage {
    //Nap anh nut MainMenu
    public ImageView Create_MainMenu(){
        Image image = new Image("file:/home/nguyen/Desktop/Image/Menu.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }
    // Nap anh nut Play
    public ImageView CreateImagePlay(){
        Image image1 = new Image("file:/home/nguyen/Desktop/Image/1.png");
        ImageView imageView1 = new ImageView(image1);
        return imageView1;
    }
    // Nap anh nut Tower_1
    public ImageView CreateImageTower_1(){
        Image image1 = new Image("file:/home/nguyen/Desktop/Image/Tower1.png");
        ImageView imageView1 = new ImageView(image1);
        return imageView1;
    }

    // Nap anh Start
    public ImageView CreateImageStart(){
        Image image = new Image("file:/home/nguyen/Desktop/Image/Start.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(37);
        imageView.setFitWidth(120);
        return imageView;
    }
    // Nap anh nut Next_Level
    public ImageView CreateImage_NextLevel(){
        Image image = new Image("file:/home/nguyen/Desktop/Image/NextLevel.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(120);
        imageView.setFitHeight(37);
        return imageView;
    }
}
