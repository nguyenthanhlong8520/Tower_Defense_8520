package sample;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Object_2;
import Object_In_Game.Object_In_Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    int Event  = 0 ;
    Button buttonPlay , buttonMainMenu;
    Scene scene_Play , scene_Background;
    Group Root_Menu , Root_BackGround;
    int x = 0 , x1 =90 , M = 45;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1400, 700);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        CreateLinkImage createLinkImage = new CreateLinkImage();
        BackGround Background = new BackGround();

        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(550);
        Root_BackGround = new Group();
        Root_BackGround.getChildren().addAll(canvas,buttonMainMenu);
        scene_Background =  new Scene(Root_BackGround , 1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                System.out.println("MainMenu");
                Event = 0;
            }
        });

        // Khởi tạo nút Play và xử lý sự kiện.
        buttonPlay = new Button();
        buttonPlay.setGraphic(createLinkImage.CreateImagePlay());
        buttonPlay.setLayoutX(600);
        buttonPlay.setLayoutY(250);
        Root_Menu = new Group();
        Root_Menu.getChildren().addAll( Background.drawRobot(graphicsContext) , buttonPlay); // Background Màn hình chờ .
        scene_Play = new Scene( Root_Menu ,1400,700 ) ;
        buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Background);
                System.out.println("Play");
                Event = 1;
            }
        });
        //Kết thúc.
        primaryStage.setScene(scene_Play);
        primaryStage.show();
        Update(graphicsContext);
    }

    // Object là cái xe , Object_2 là cái xe đang chạy trên game .

    int Object1_x1 = 1200 , Object_y1 = 300 , Speed_1 = 2 ;
    int Speed_2 = 2 ,Object2_x2 = 1200 , Object2_y2 = 300;

    public void Update(GraphicsContext gc) throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // Khởi tạo hàm vẽ background Game và nhân vật.
                BackGround Obj = new BackGround();
                CreateLinkImage createLinkImage = new CreateLinkImage();
                Object_In_Game  Object_2;
                Obj.drawShapes(gc);
                Obj.draw_Background_GREEN(gc);
                Object_2 = new Object_2(Object2_x2,Object2_y2,Speed_2);
                gc.drawImage(Object_2.Create_Object(x),Object_2.getValue_X(),Object_2.getValue_Y());
                gc.drawImage(Object_2.Create_Health(x1) , Object_2.getValue_X() + M ,Object_2.getValue_Y());
                System.out.println(Object2_x2);
                if (Event ==1 ){
                    Action();
                }
                Update();
            }
        };
        animationTimer.start();
    }

    // Tất cả các hàm di chuyển và định hướng đi (Quay) để vào đây .
    public void Action(){
        Move_Object1();
        Direction_Object1();
    }

    //
    public void Move_Object1(){
        if (Object2_x2 > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Object2_x2 -= Speed_2;   // đi thẳng
        }
        else if (Object2_x2 == 610 && Object2_y2 < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Object2_y2 += Speed_2; // tọa độ y tăng lên (di chuyển xuống phía dưới)
        }
        else if (Object2_x2 > 350 && Object2_y2 == 430){ // di chuyen sang PHAI
            Object2_x2 -= Speed_2; // di sang trai
        }
        else if (Object2_x2 == 350 && Object2_y2 > 150){
            Object2_y2 -= Speed_2; // di len
        }
        else if ( Object2_x2 > 150 && Object2_y2 == 150){
            Object2_x2 -= Speed_2; //di sang trai
        }
        else if (Object2_x2 == 150 && Object2_y2 < 360 ){
            Object2_y2 += Speed_2; // di xuong
        }
        else if (Object2_x2 > -90 && Object2_y2 == 360){
            Object2_x2 -= Speed_2; // di sang trai
        }

    }
    public void Direction_Object1(){
        if (Object2_x2 == 610 && Object2_y2 == 300 && x > -90){ // Quay đầu đoạn rẽ thứ nhất
            Object2_x2 += Speed_2; // cộng tọa độ của xObject2 để nó đứng im quay đầu .
            x-=2; // rẽ trái
            x1-=2;
            M=0;
        }
        else if (Object2_x2 == 610 && Object2_y2 == 430 && x < 0){ // quay phải đoạn thứ nhất
            Object2_x2 += Speed_2;
            x+=2;
            x1+=2;
            M=45;
        }
        else if (Object2_x2 == 350 && Object2_y2 == 430 && x < 90){
            Object2_y2 += Speed_2;
            x+=2;
            x1+=2;
            M=0;
        }
        else if (Object2_x2 == 350 && Object2_y2 == 150 && x > 0){
            Object2_x2 += Speed_2;
            x-=2;
            x1-=2;
        }
        else if (Object2_x2 == 150 && Object2_y2 == 150 && x > -90){
            Object2_y2 -= Speed_2;
            x-=2;
            x1-=2;
        }
        else if (Object2_x2 == 150 && Object2_y2 == 360 && x < 0 ){
            Object2_x2 += Speed_2;
            x+=2;
            x1+=2;
        }
    }
    public void Direction_Object2(){
        if (Object1_x1 == 610 && Object_y1 == 300 && x > -90){ // Quay đầu đoạn rẽ thứ nhất
            Object1_x1 += Speed_2; // cộng tọa độ của xObject2 để nó đứng im quay đầu .
            x1--; // rẽ trái
        }
        else if (Object1_x1 == 610 && Object_y1 == 430 && x < 0){ // quay phải đoạn thứ nhất
            Object1_x1 += Speed_2;
            x1++;
        }
        else if (Object1_x1 == 350 && Object_y1 == 430 && x < 90){
            Object_y1 += Speed_2;
            x1++;
        }
        else if (Object1_x1 == 350 && Object_y1 == 150 && x > 0){
            Object1_x1 += Speed_2;
            x1--;
        }
        else if (Object1_x1 == 150 && Object_y1 == 150 && x > -90){
            Object_y1 -= Speed_2;
            x1--;
        }
        else if (Object1_x1 == 150 && Object_y1 == 360 && x < 0 ){
            Object1_x1 += Speed_2;
            x1++;
        }
    }
    public void Move_Object2(){
        if (Object1_x1 > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Object1_x1 -= Speed_2;   // đi thẳng sang trái
        }
        else if (Object1_x1 == 610 && Object_y1 < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Object_y1 += Speed_2; // tọa độ y tăng lên (di chuyển xuống phía dưới)
        }
        else if (Object1_x1 > 350 && Object_y1 == 430){ // di chuyen sang ngang
            Object1_x1 -= Speed_2;
        }
        else if (Object1_x1 == 350 && Object_y1 > 150){
            Object_y1 -= Speed_2;
        }
        else if ( Object1_x1 > 150 && Object_y1 == 150){
            Object1_x1 -= Speed_2;
        }
        else if (Object1_x1 == 150 && Object_y1 < 360 ){
            Object_y1 += Speed_2;
        }
        else if (Object1_x1 > -90 && Object_y1 == 360){
            Object1_x1 -= Speed_2;
            System.out.println(Object1_x1);
        }
    }

    public void Update(){
        if (Object2_x2 == -90){
            Object2_x2 = 1200;
            Object2_y2 = 300;
        }
    }
}