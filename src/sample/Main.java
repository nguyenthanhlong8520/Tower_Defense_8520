package sample;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Object_1;
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
    int Index_Map = 0;
    Stage stage;
    Button buttonMainMenu, buttonPlay_Start , buttonNext_Level, buttonMap_1 , buttonMap_2 , buttonMap_3;
    Scene scene_Play , scene_Background_1,scene_Background_2;
    Group Root_Menu , Root_BackGround_1 , Root_BackGround_2;
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

        // chọn bản đồ 1
        buttonMap_1 = new Button();
        buttonMap_1.setGraphic(createLinkImage.CreateImage_Map1());
        buttonMap_1.setLayoutX(500);
        buttonMap_1.setLayoutY(450);
        buttonMap_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Index_Map = 1;
                 Match_Map_1(primaryStage, createLinkImage, Background, graphicsContext , canvas);
            }
        });
        // Nút chọn bản đồ 2
        buttonMap_2 = new Button();
        buttonMap_2.setGraphic(createLinkImage.CreateImage_Map2());
        buttonMap_2.setLayoutX(650);
        buttonMap_2.setLayoutY(450);
        buttonMap_2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                Index_Map = 2;
                Match_Map_2(primaryStage, createLinkImage, Background, graphicsContext , canvas);
            }
        });
        //  Nút chọn bản đồ 3
        buttonMap_3 = new Button();
        buttonMap_3.setGraphic(createLinkImage.CreateImage_Map3());
        buttonMap_3.setLayoutX(800);
        buttonMap_3.setLayoutY(450);
        buttonMap_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Index_Map = 3;
                Match_Map_3(primaryStage, createLinkImage, Background, graphicsContext , canvas);
            }
        });
        Root_Menu = new Group();
        Root_Menu.getChildren().addAll( Background.drawBackground_Wait(graphicsContext),buttonMap_1,buttonMap_2,buttonMap_3); // Background Màn hình chờ .
        scene_Play = new Scene( Root_Menu ,1400,700 ) ;
        //Kết thúc.
        primaryStage.setScene(scene_Play);
        // Match_Map_2(primaryStage, createLinkImage, Background, graphicsContext , canvas);
        primaryStage.show();
        Update_Match(graphicsContext);
    }
    // Value of speed can change : 1,2,5,10

    int Speed_1 = 5 , Object_x1 = 1200 , Object_y1 = 300;

    public void Update_Match(GraphicsContext gc) throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // Khởi tạo hàm vẽ background Game và nhân vật.
                BackGround Obj = new BackGround();
                CreateLinkImage createLinkImage = new CreateLinkImage();
                Object_In_Game  Object_1 ;
                if (Index_Map == 1){  // chạy Map 1
                    Obj.draw_Background_Match_1(gc);
                    Object_1 = new Object_1(Object_x1, Object_y1, Speed_1);
                    gc.drawImage(Object_1.Create_Object(angle),Object_1.getValue_X(),Object_1.getValue_Y());
                    gc.drawImage(Object_1.Create_Health(x1) , Object_1.getValue_X()+ M,Object_1.getValue_Y());
                    Obj.draw_Background_GREEN(gc);
                    Event(Object_1);
                    Update();
                }
                else if (Index_Map == 2){ // chạy Map 2
                    Obj.draw_Background_Match_2(gc);
                }
                else if (Index_Map == 3){ // Chạy Map 3
                    Obj.draw_Background_Match_3(gc);
                }
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
    public void Match_Map_1(Stage primaryStage,CreateLinkImage createLinkImage, BackGround Background
    , GraphicsContext graphicsContext , Canvas canvas){
        // nút ấn NextLevel
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
        Root_BackGround_1 = new Group();
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1, 1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                MainMenu();
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }
    public void Match_Map_2(Stage primaryStage,CreateLinkImage createLinkImage, BackGround Background
    , GraphicsContext graphicsContext , Canvas canvas){
        // nút ấn NextLevel
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
        Root_BackGround_1 = new Group();
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1, 1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                MainMenu();
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }
    public void Match_Map_3(Stage primaryStage,CreateLinkImage createLinkImage, BackGround Background
    , GraphicsContext graphicsContext , Canvas canvas){
        // nút ấn NextLevel
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
        Root_BackGround_1 = new Group();
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1, 1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                MainMenu();
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }
}