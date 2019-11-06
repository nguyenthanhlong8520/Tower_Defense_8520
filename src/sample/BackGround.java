package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackGround {

    // Backgound cua man hinh choi.
    public void draw_Background_Match_1(GraphicsContext gc) {
        Image BackGround = new Image("file:/home/nguyen/Desktop/Image/Bg.png");
        gc.drawImage(BackGround,0,0,1000,700);
    }
    //
    public void draw_Background_Match_2(GraphicsContext gc){
        Image BackGround = new Image("file:/home/nguyen/Desktop/Image/Map2.jpg");
        gc.drawImage(BackGround,0,0,1000,700);
    }
    //
    public void draw_Background_Match_3(GraphicsContext gc){
        Image BackGround = new Image("file:/home/nguyen/Desktop/Image/Xuanloc.png");
        gc.drawImage(BackGround,0,0,1000,700);
    }

    // Background của màn hình chờ
    public  ImageView drawBackground_Wait(GraphicsContext gc){
        Image BackgroundMenu = new Image("file:/home/nguyen/Desktop/Image/a.jpg"); // hinh` thang ro bot
        ImageView imageView2 = new ImageView(BackgroundMenu);
        imageView2.setX(0);
        imageView2.setY(0);
        imageView2.setFitHeight(700);
        imageView2.setFitWidth(1400);
        return imageView2;
    }

    public void draw_Background_GREEN(GraphicsContext gc) {
        Label label = new Label();
        ImageView imageView = new ImageView();
        Image Test = new Image("file:/home/nguyen/Desktop/Image/h10.jpg");
        gc.drawImage(Test,1000,0,400,700);
    }

}