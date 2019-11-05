package sample;
import Tower.Tower_1;
import Tower.Tower;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Object_1;
import Object_In_Game.Object_2;
import Object_In_Game.Object_In_Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    int Event  = 0 ;
    Button buttonPlay , buttonMainMenu, buttonPlay_Start , buttonNext_Level;
    Scene scene_Play , scene_Background;
    Group Root_Menu , Root_BackGround;
    int angle = 0 ,Rotate_Gun = 0, x1 = 90 , M = 30 , Count_Number_Pass;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1400, 700);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        CreateLinkImage createLinkImage = new CreateLinkImage();
        BackGround Background = new BackGround();

        //
        buttonNext_Level = new Button();
        buttonNext_Level.setGraphic(createLinkImage.CreateImage_NextLevel());
        buttonNext_Level.setLayoutX(1150);
        buttonNext_Level.setLayoutY(350);
        buttonNext_Level.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Count_Number_Pass == 5){
                    Event = 1;
                    Speed_1 = 10;
                }
            }
        });
        //

        //  Nút play bắt đầu cho xe chạy.
        buttonPlay_Start = new Button();
        buttonPlay_Start.setGraphic(createLinkImage.CreateImageStart());
        buttonPlay_Start.setLayoutX(1150);
        buttonPlay_Start.setLayoutY(450);
        buttonPlay_Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Event = 1;
            }
        });
        //
        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(550);
        Root_BackGround = new Group();
        Root_BackGround.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background =  new Scene(Root_BackGround , 1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                System.out.println("MainMenu");
                MainMenu();
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
            }
        });
        //Kết thúc.
        primaryStage.setScene(scene_Play);
        primaryStage.show();
        Update(graphicsContext);
    }

    // Value of speed can change : 1,2,5,10
    int Speed_1 = 5 , Object_x1 = 1200 , Object_y1 = 300;
    int Speed_2 = 5 , Object_x2 = 1200 , Object_y2 = 300;
    public void Update(GraphicsContext gc) throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // Khởi tạo hàm vẽ background Game và nhân vật.
                //
                Tower tower = new Tower_1(1000,310);
                //
                BackGround Obj = new BackGround();
                CreateLinkImage createLinkImage = new CreateLinkImage();
                Object_In_Game  Object_1 , Object_2;
                Obj.drawShapes(gc);
                Object_1 = new Object_1(Object_x1, Object_y1, Speed_1);
                Object_2 = new Object_2(Object_x2, Object_y2, Speed_2);
                //Object_1
                gc.drawImage(Object_1.Create_Object(angle),Object_1.getValue_X(),Object_1.getValue_Y());
                gc.drawImage(Object_1.Create_Health(x1) , Object_1.getValue_X()+ M,Object_1.getValue_Y());
                //Object2


                Obj.draw_Background_GREEN(gc);
                Event(Object_1);
                Update();
                System.out.println(Count_Number_Pass);
            }
        };
        animationTimer.start();
    }
    public void Action_Object_1(Object_In_Game Object_1){
        Move_Object1(Object_1);
        Direction_Object1(Object_1);
    }

    public void Move_Object1(Object_In_Game Object_1){
        if (Object_x1 > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Object_x1 -= Object_1.getSpeed();   // đi thẳng
        }
        else if (Object_x1 == 610 && Object_y1 < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Object_y1 += Object_1.getSpeed(); // tọa độ y tăng lên (di chuyển xuống phía dưới)
        }
        else if (Object_x1 > 350 && Object_y1 == 430){ // di chuyen sang PHAI
            Object_x1 -= Object_1.getSpeed();; // di sang trai
        }
        else if (Object_x1 == 350 && Object_y1 > 150){
            Object_y1 -= Object_1.getSpeed();; // di len
        }
        else if ( Object_x1 > 150 && Object_y1 == 150){
            Object_x1 -= Object_1.getSpeed();; //di sang trai
        }
        else if (Object_x1 == 150 && Object_y1 < 360 ){
            Object_y1 += Object_1.getSpeed();; // di xuong
        }
        else if (Object_x1 > -90 && Object_y1 == 360){
            Object_x1 -= Object_1.getSpeed();; // di sang trai
        }

    }
    public void Direction_Object1(Object_In_Game Object_1){
        if (Object_x1 == 610 && Object_y1 == 300 && angle > -90){ // Quay đầu đoạn rẽ thứ nhất
            Object_x1 += Object_1.getSpeed();; // cộng tọa độ của xObject2 để nó đứng im quay đầu .
            angle = -90; // rẽ trái
        }
        else if (Object_x1 == 610 && Object_y1 == 430 && angle < 0){ // quay phải đoạn thứ nhất
            Object_x1 += Object_1.getSpeed();;
            angle =0;
        }
        else if (Object_x1 == 350 && Object_y1 == 430 && angle < 90){
            Object_y1 += Object_1.getSpeed();;
            angle = 90;
        }
        else if (Object_x1 == 350 && Object_y1 == 150 && angle > 0){
            Object_x1 += Object_1.getSpeed();;
            angle = 0;
        }
        else if (Object_x1 == 150 && Object_y1 == 150 && angle > -90){
            Object_y1 -= Object_1.getSpeed();;
            angle = -90;
        }
        else if (Object_x1 == 150 && Object_y1 == 360 && angle < 0 ){
            Object_x1 += Object_1.getSpeed();;
            angle = 0;
        }
    }

    public void Update(){
        if (Object_x1 == -90){
            Object_x1 = 1200;
            Object_y1 = 300;
            Count_Number_Pass();
        }
    }
    void Event(Object_In_Game Object_1){
        if (Event == 1){
            Action_Object_1(Object_1);
        }
    }
    void MainMenu(){
        Object_x1 = 1200;
        Object_y1 = 300;
        Event = 0;
    }
    void Count_Number_Pass(){
        Count_Number_Pass++;
        if (Count_Number_Pass == 5 || Count_Number_Pass == 10) Event = 0;
    }
}