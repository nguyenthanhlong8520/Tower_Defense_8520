package Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;

public class BackGround {
    // Backgound cua man hinh choi.
    public void draw_Background_Match_1(GraphicsContext gc) {
        Image BackGround = new Image("file:src/AssetsKit/Bg.png");
        gc.drawImage(BackGround,0,0,1000,700);
    }
    //
    public void draw_Background_Match_2(GraphicsContext gc){
        Image BackGround = new Image("file:src/AssetsKit/Map2.jpg");
        gc.drawImage(BackGround,0,0,1000,700);
    }
    //
    public void draw_Background_Match_3(GraphicsContext gc){
        Image BackGround = new Image("file:src/AssetsKit/Xuanloc.png");
        gc.drawImage(BackGround,0,0,1000,700);
    }
    // Background của màn hình chờ
    public  ImageView drawBackground_Wait(GraphicsContext gc){
        Image BackgroundMenu = new Image("file:src/AssetsKit/a.jpg"); // hinh` thang ro bot
        ImageView imageView2 = new ImageView(BackgroundMenu);
        imageView2.setX(0);
        imageView2.setY(0);
        imageView2.setFitHeight(700);
        imageView2.setFitWidth(1400);
        return imageView2;
    }
    public void draw_Background_GREEN(GraphicsContext gc) {
        Image Test = new Image("file:src/AssetsKit/h10.jpg");
        gc.drawImage(Test,1000,0,400,700);
    }
    //
    public ImageView Game_Over(GraphicsContext gc) {
        Image gameOver = new Image("file:src/AssetsKit/Game_Over.jpg");
        ImageView imageView = new ImageView(gameOver);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitWidth(1400);
        imageView.setFitHeight(700);
        return imageView;
    }
    public void draw_tree(GraphicsContext gc) {
        Image tree = new Image("file:src/AssetsKit/tree.png");
        gc.drawImage(tree,581,190,112,112);
        gc.drawImage(tree,43,110,112,112);
    }
}