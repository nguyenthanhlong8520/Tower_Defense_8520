package sample;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Monster_Car;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main_Test extends Application {
    boolean Event = false;
    int Index_Map = 0;
    Button buttonMainMenu, buttonPlay_Start , buttonNext_Level, buttonMap_1 , buttonMap_2 , buttonMap_3;
    Scene scene_Play , scene_Background_1,scene_Background_2;
    Group Root_Menu , Root_BackGround_1 , Root_BackGround_2;
    int Count_Pass = 0;

    public static void main(String[] args) {
        launch(args);
    }

    GraphicsContext graphicsContext;
    List<Monster_Car> Manager_Object_Car = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1400, 700);
        graphicsContext = canvas.getGraphicsContext2D();
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
        Root_Menu.getChildren().addAll( Background.drawBackground_Wait(graphicsContext),buttonMap_1,
                buttonMap_2,buttonMap_3); // Background Màn hình chờ .
        scene_Play = new Scene( Root_Menu ,1400,700 ) ;
        //Kết thúc.
        primaryStage.setScene(scene_Play);
        primaryStage.show();
        Update_Match(graphicsContext);
    }
    // Value of speed can change : 1,2,5,10

    public void Match_Map_1(Stage primaryStage,CreateLinkImage createLinkImage, BackGround Background
            , GraphicsContext graphicsContext , Canvas canvas){
        // Hien thi Health
        // nút ấn NextLevel
        Label label = new Label("My Label" + " " + 1);
        buttonNext_Level = new Button();
        buttonNext_Level.setGraphic(createLinkImage.CreateImage_NextLevel());
        buttonNext_Level.setLayoutX(1150);
        buttonNext_Level.setLayoutY(280);
        buttonNext_Level.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });
        //
        //  Nút play bắt đầu cho xe chạy.
        buttonPlay_Start = new Button();
        buttonPlay_Start.setGraphic(createLinkImage.CreateImageStart());
        buttonPlay_Start.setLayoutX(1150);
        buttonPlay_Start.setLayoutY(580);
        buttonPlay_Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                  Event = true;
            }
        });
        //
        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(650);
        Root_BackGround_1 = new Group();
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1,1400,700);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                Event = false;
                Return_1();
                Return_2();
                Return_3();
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
                if (Count_Pass == 5){

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
                if (Count_Pass == 5){

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
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }

    public void Update_Match(GraphicsContext gc) throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // Khởi tạo hàm vẽ background Game và nhân vật.
                BackGround Obj = new BackGround();
                if (Index_Map == 1){  // chạy Map 1
                    Obj.draw_Background_Match_1(gc);
                    if (Event == true){
                        Render();
                        Monster_Update_Move();
                        Monster_Update_Move_2();
                        Monster_Update_Move_3();
                        Return_1();
                        Return_2();
                        Return_3();
                    }
                    Obj.draw_Background_GREEN(gc);
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
        Manager_Object_Car.add(Create_Monster_1());
        Manager_Object_Car.add(Create_Monster_2());
        Manager_Object_Car.add(Create_Monster_3());
    }

    public Monster_Car Create_Monster_1(){
        Monster_Car monster_car = new Monster_Car();
        monster_car.image = new Image("file:/home/nguyen/Desktop/Image/233.png");
        monster_car.x = 1200;
        monster_car.y = 300;
        monster_car.Speed = 5;
        monster_car.Rotate = 0;
        return monster_car;
    }
    public Monster_Car Create_Monster_2(){
        Monster_Car monster_car = new Monster_Car();
        monster_car.image = new Image("file:/home/nguyen/Desktop/Image/231.png");
        monster_car.x = 1500;
        monster_car.y = 300;
        monster_car.Speed = 5;
        monster_car.Rotate = 0;
        return monster_car;
    }
    public Monster_Car Create_Monster_3(){
        Monster_Car monster_car = new Monster_Car();
        monster_car.image = new Image("file:/home/nguyen/Desktop/Image/231.png");
        monster_car.x = 1600;
        monster_car.y = 300;
        monster_car.Speed = 5;
        monster_car.Rotate = 0;
        return monster_car;
    }

    // Ham` render chung
    public void Render(){
        Manager_Object_Car.forEach(g->g.Render(graphicsContext));
        Manager_Object_Car.forEach(g->g.Blood_bar(graphicsContext));
    }
    // Monster_1
    public void Monster_Update_Move(){
        if (Manager_Object_Car.get(0).getX() > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Manager_Object_Car.get(0).Move_Left();
        }
        else if (Manager_Object_Car.get(0).getX() == 610 && Manager_Object_Car.get(0).getY() < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Manager_Object_Car.get(0).Move_Down();
            Manager_Object_Car.get(0).setRotate(-90);
        }
        else if (Manager_Object_Car.get(0).getX() > 350 && Manager_Object_Car.get(0).getY() == 430){ // di chuyen sang PHAI
            Manager_Object_Car.get(0).Move_Left(); // di sang trai
            Manager_Object_Car.get(0).setRotate(0);
        }
        else if (Manager_Object_Car.get(0).getX() == 350 && Manager_Object_Car.get(0).getY() > 150){
            Manager_Object_Car.get(0).Move_Up(); // di len
            Manager_Object_Car.get(0).setRotate(90);
        }
        else if ( Manager_Object_Car.get(0).getX() > 150 && Manager_Object_Car.get(0).getY() == 150){
            Manager_Object_Car.get(0).Move_Left(); //di sang trai
            Manager_Object_Car.get(0).setRotate(0);
        }
        else if (Manager_Object_Car.get(0).getX() == 150 && Manager_Object_Car.get(0).getY() < 360 ){
            Manager_Object_Car.get(0).Move_Down(); // di xuong
            Manager_Object_Car.get(0).setRotate(-90);
        }
        else if (Manager_Object_Car.get(0).getX() > -90 && Manager_Object_Car.get(0).getY() == 360){
            Manager_Object_Car.get(0).Move_Left(); // di sang trai
            Manager_Object_Car.get(0).setRotate(0);
        }
    }
    public void Return_1(){
        if (Manager_Object_Car.get(0).getX() <= -30 || Event == false){
            Manager_Object_Car.get(0).setX(1200);
            Manager_Object_Car.get(0).setY(300);
            Manager_Object_Car.get(0).setRotate(0);
        }
    }
    // Monster_ 2
    public void Monster_Update_Move_2(){
        if (Manager_Object_Car.get(1).getX() > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Manager_Object_Car.get(1).Move_Left();
        }
        else if (Manager_Object_Car.get(1).getX() == 610 && Manager_Object_Car.get(1).getY() < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Manager_Object_Car.get(1).Move_Down();
            Manager_Object_Car.get(1).setRotate(-90);
        }
        else if (Manager_Object_Car.get(1).getX() > 350 && Manager_Object_Car.get(1).getY() == 430){ // di chuyen sang PHAI
            Manager_Object_Car.get(1).Move_Left(); // di sang trai
            Manager_Object_Car.get(1).setRotate(0);
        }
        else if (Manager_Object_Car.get(1).getX() == 350 && Manager_Object_Car.get(1).getY() > 150){
            Manager_Object_Car.get(1).Move_Up(); // di len
            Manager_Object_Car.get(1).setRotate(90);
        }
        else if ( Manager_Object_Car.get(1).getX() > 150 && Manager_Object_Car.get(1).getY() == 150){
            Manager_Object_Car.get(1).Move_Left(); //di sang trai
            Manager_Object_Car.get(1).setRotate(0);
        }
        else if (Manager_Object_Car.get(1).getX() == 150 && Manager_Object_Car.get(1).getY() < 360 ){
            Manager_Object_Car.get(1).Move_Down(); // di xuong
            Manager_Object_Car.get(1).setRotate(-90);
        }
        else if (Manager_Object_Car.get(1).getX() > -90 && Manager_Object_Car.get(1).getY() == 360){
            Manager_Object_Car.get(1).Move_Left(); // di sang trai
            Manager_Object_Car.get(1).setRotate(0);
        }
    }
    public void Return_2(){
        if (Manager_Object_Car.get(1).getX() <= -30 || Event == false){
            Manager_Object_Car.get(1).setX(1400);
            Manager_Object_Car.get(1).setY(300);
            Manager_Object_Car.get(1).setRotate(0);
        }
    }
    //Monster_3
    public void Monster_Update_Move_3(){
        if (Manager_Object_Car.get(2).getX() > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Manager_Object_Car.get(2).Move_Left();
        }
        else if (Manager_Object_Car.get(2).getX() == 610 && Manager_Object_Car.get(2).getY() < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Manager_Object_Car.get(2).Move_Down();
            Manager_Object_Car.get(2).setRotate(-90);
        }
        else if (Manager_Object_Car.get(2).getX() > 350 && Manager_Object_Car.get(2).getY() == 430){ // di chuyen sang PHAI
            Manager_Object_Car.get(2).Move_Left(); // di sang trai
            Manager_Object_Car.get(2).setRotate(0);
        }
        else if (Manager_Object_Car.get(2).getX() == 350 && Manager_Object_Car.get(2).getY() > 150){
            Manager_Object_Car.get(2).Move_Up(); // di len
            Manager_Object_Car.get(2).setRotate(90);
        }
        else if ( Manager_Object_Car.get(2).getX() > 150 && Manager_Object_Car.get(2).getY() == 150){
            Manager_Object_Car.get(2).Move_Left(); //di sang trai
            Manager_Object_Car.get(2).setRotate(0);
        }
        else if (Manager_Object_Car.get(2).getX() == 150 && Manager_Object_Car.get(2).getY() < 360 ){
            Manager_Object_Car.get(2).Move_Down(); // di xuong
            Manager_Object_Car.get(2).setRotate(-90);
        }
        else if (Manager_Object_Car.get(2).getX() > -90 && Manager_Object_Car.get(2).getY() == 360){
            Manager_Object_Car.get(2).Move_Left(); // di sang trai
            Manager_Object_Car.get(2).setRotate(0);
        }
    }
    public void Return_3(){
        if (Manager_Object_Car.get(2).getX() <= -30 || Event == false){
            Manager_Object_Car.get(2).setX(1600);
            Manager_Object_Car.get(2).setY(300);
            Manager_Object_Car.get(2).setRotate(0);
        }
    }
}
