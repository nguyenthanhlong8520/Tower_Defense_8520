package sample;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Monster_Car;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kotlin.text.MatchNamedGroupCollection;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    boolean Event = false;
    int Index_Map = 0 , Index_Coordinates = 0;
    int i = 0 ;  // i đại diện cho monster thứ bao nhiêu , ví dụ monster thứ nhất : Manager_Object_Car.get(0);
    long  timeOfLastFrameSwtich =0;
    Button buttonMainMenu, buttonPlay_Start , buttonNext_Level, buttonMap_1 , buttonMap_2 , buttonMap_3;
    Scene scene_Play , scene_Background_1,scene_Background_2;
    Group Root_Menu , Root_BackGround_1 , Root_BackGround_2;
    int Count_Pass = 0;

    public static void main(String[] args) {
        launch(args);
    }
    GraphicsContext graphicsContext;
    List<Monster_Car> Manager_Object_Car = new ArrayList<>(); // tạo một danh sách các đối tượng kiểu Monster_car.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1400, 900);
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
                Index_Coordinates = 1;
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
                Index_Coordinates = 2;
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
                Index_Coordinates = 3;
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
    int x = 0;
    public void Match_Map_1(Stage primaryStage,CreateLinkImage createLinkImage, BackGround Background
            , GraphicsContext graphicsContext , Canvas canvas){
        // nút ấn NextLevel
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
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_Start_1(j);
                }
                Event = true;
            }
        });

        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(650);

        Root_BackGround_1 = new Group(Lives(),Funds(),Wave());
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1,1400,800);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                Event = false;
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_1(j);
                }
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
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_Start_2(j);
                }
                Event = true;
            }
        });
        //
        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(550);
        Root_BackGround_1 = new Group(Funds(),Lives(),Wave());
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1, 1400,800);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                Event = false;
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_2(j);
                }
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
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_Start_3(j);
                }
                Event = true;
            }
        });
        //
        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(550);
        Root_BackGround_1 = new Group(Lives(),Funds(),Wave());
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level);
        scene_Background_1 =  new Scene(Root_BackGround_1, 1400,800);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                Event = false;
                for (int j = 0 ; j < Manager_Object_Car.size() ; j++){
                    Return_3(j);
                }
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }

    List<Integer> integers = new ArrayList<>(); // Mảng số nguyên chứa

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
                        for (int j = 0 ; j < integers.size() ; j++){ // Liên tục gọi sự di chuyển của các đối tượng
                            // , nếu ko có vòng for này thì chỉ chạy đc 1 con một .
                            Monster_Update_Move(j);
                            Return_1(j);            // Nếu đi con xe đi đến vị trí cuối thì tọa đồ return lại từ đầu.
                        }
                        if( System.nanoTime() - timeOfLastFrameSwtich >= 1000000000 && i < Manager_Object_Car.size()){
                            i++;
                            integers.add(i);
                            System.out.println( System.nanoTime() - timeOfLastFrameSwtich );
                            timeOfLastFrameSwtich = System.nanoTime();
                            //  System.out.println(Manager_Object_Car.size());
                        }
                    }
                    Obj.draw_Background_GREEN(gc);
                }
                else if (Index_Map == 2){ // chạy Map 2
                    Obj.draw_Background_Match_2(gc);
                    if (Event == true){
                        Render();
                        for (int j = 0 ; j < integers.size() ; j++){ // Liên tục gọi sự di chuyển của các đối tượng
                            // , nếu ko có vòng for này thì chỉ chạy đc 1 con một .
                            Monster_Update_Move_Map2(j);
                            Return_2(j);            // Nếu đi con xe đi đến vị trí cuối thì tọa đồ return lại từ đầu.
                        }
                        if( System.nanoTime() - timeOfLastFrameSwtich >= 1000000000 && i < Manager_Object_Car.size()){
                            i++;
                            integers.add(i);
                            // System.out.println( System.nanoTime() - timeOfLastFrameSwtich );
                            timeOfLastFrameSwtich = System.nanoTime();
                            // System.out.println(Manager_Object_Car.size());
                        }
                    }
                    Obj.draw_Background_GREEN(gc);
                }
                else if (Index_Map == 3){ // Chạy Map 3
                    Obj.draw_Background_Match_3(gc);
                    if (Event == true){
                        Render();
                        for (int j = 0 ; j < integers.size() ; j++){ // Liên tục gọi sự di chuyển của các đối tượng
                            // , nếu ko có vòng for này thì chỉ chạy đc 1 con một .
                            Monster_Update_Move_Map3(j);
                            Return_3(j);
                        }
                        if( System.nanoTime() - timeOfLastFrameSwtich >= 1000000000 && i < Manager_Object_Car.size()){
                            i++;
                            integers.add(i);
                            timeOfLastFrameSwtich = System.nanoTime();
                        }
                    }
                    Obj.draw_Background_GREEN(gc);
                }
            }
        };
        animationTimer.start();
        // them doi tuong game o day
        Manager_Object_Car.add(Create_Monster_Car());
        Manager_Object_Car.add(Create_Monster_Car());
        Manager_Object_Car.add(Create_Monster_Car());
        Manager_Object_Car.add(Create_Monster_Car());
        Manager_Object_Car.add(Create_Monster_Car());
        Manager_Object_Car.add(Create_Monster_Car());
        //System.out.println(Manager_Object_Car.size());
    }

    // Khởi tạo đối tượng xe .

    public Monster_Car Create_Monster_Car(){
        Monster_Car monster_car = new Monster_Car() ;
        monster_car.image = new Image("file:/home/nguyen/Desktop/Image/233.png") ;
        if (Index_Coordinates == 1){
            monster_car.x = 1200 ;
            monster_car.y = 300 ;
        }
        else if (Index_Coordinates == 2){
            monster_car.x = 1200 ;
            monster_car.y = 225 ;
        }
        else if (Index_Coordinates == 3){
            monster_car.x = 1200;
            monster_car.y = 45;
        }
        monster_car.Speed = 5 ;
        monster_car.Rotate = 0 ;
        return monster_car ;
    }

    // Ham` render chung .
    public void Render(){
        Manager_Object_Car.forEach(g->g.Render(graphicsContext));
        Manager_Object_Car.forEach(g->g.Blood_bar(graphicsContext));
    }
    //  Monster Map_1
    public void Monster_Update_Move(int i){
        if (Manager_Object_Car.get(i).getX() > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Manager_Object_Car.get(i).Move_Left();
        }
        else if (Manager_Object_Car.get(i).getX() == 610 && Manager_Object_Car.get(i).getY() < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > 350 && Manager_Object_Car.get(i).getY() == 430){ // di chuyen sang PHAI
            Manager_Object_Car.get(i).Move_Left(); // di sang trai
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 350 && Manager_Object_Car.get(i).getY() > 150){
            Manager_Object_Car.get(i).Move_Up(); // di len
            Manager_Object_Car.get(i).setRotate(90);
        }
        else if ( Manager_Object_Car.get(i).getX() > 150 && Manager_Object_Car.get(i).getY() == 150){
            Manager_Object_Car.get(i).Move_Left(); //di sang trai
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 150 && Manager_Object_Car.get(i).getY() < 360 ){
            Manager_Object_Car.get(i).Move_Down(); // di xuong
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > -90 && Manager_Object_Car.get(i).getY() == 360){
            Manager_Object_Car.get(i).Move_Left(); // di sang trai
            Manager_Object_Car.get(i).setRotate(0);
        }
    }

    //  Monster Map_2
    public void Monster_Update_Move_Map2(int i){
        if (Manager_Object_Car.get(i).getX() > 770){
            Manager_Object_Car.get(i).Move_Left();
        }
        else if (Manager_Object_Car.get(i).getX() == 770 && Manager_Object_Car.get(i).getY() < 460){
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > 405 && Manager_Object_Car.get(i).getY() == 460){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 405 && Manager_Object_Car.get(i).getY() > 50){
            Manager_Object_Car.get(i).Move_Up();
            Manager_Object_Car.get(i).setRotate(90);
        }
        else if (Manager_Object_Car.get(i).getX() > -90 && Manager_Object_Car.get(i).getY() == 50){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
    }

    // Monster Map_3
    public void Monster_Update_Move_Map3(int i){
        if (Manager_Object_Car.get(i).getX() > 735 && Manager_Object_Car.get(i).getY() == 45){
            Manager_Object_Car.get(i).Move_Left();
        }
        else if (Manager_Object_Car.get(i).getX() == 735 && Manager_Object_Car.get(i).getY() < 195){
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > 495 && Manager_Object_Car.get(i).getY() == 195){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 495 && Manager_Object_Car.get(i).getY() > 45 && Manager_Object_Car.get(i).getY() < 330){
            Manager_Object_Car.get(i).Move_Up();
            Manager_Object_Car.get(i).setRotate(90);
        }
        else if (Manager_Object_Car.get(i).getX() > 100 && Manager_Object_Car.get(i).getY() == 45){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 100 && Manager_Object_Car.get(i).getY() < 330){
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() < 820 && Manager_Object_Car.get(i).getY() == 330){
            Manager_Object_Car.get(i).Move_Right();
            Manager_Object_Car.get(i).setRotate(180);
        }
        else if (Manager_Object_Car.get(i).getX() == 820 && Manager_Object_Car.get(i).getY() < 550){
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > 590 && Manager_Object_Car.get(i).getY() == 550){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 590 && Manager_Object_Car.get(i).getY() > 440){
            Manager_Object_Car.get(i).Move_Up();
            Manager_Object_Car.get(i).setRotate(90);
        }
        else if (Manager_Object_Car.get(i).getX() > 345 && Manager_Object_Car.get(i).getY() == 440){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
        else if (Manager_Object_Car.get(i).getX() == 345 && Manager_Object_Car.get(i).getY() < 535){
            Manager_Object_Car.get(i).Move_Down();
            Manager_Object_Car.get(i).setRotate(-90);
        }
        else if (Manager_Object_Car.get(i).getX() > 0 && Manager_Object_Car.get(i).getY() == 535){
            Manager_Object_Car.get(i).Move_Left();
            Manager_Object_Car.get(i).setRotate(0);
        }
    }

    // Khi đếm điểm c thì trả về tọa độ từ đầu.
    public void Return_1(int i){
        if ((Manager_Object_Car.get(i).getX() <= 0 ) || Event == false){
            x++;
            Manager_Object_Car.get(i).setX(1200);
            Manager_Object_Car.get(i).setY(300);
            Manager_Object_Car.get(i).setRotate(0);
        }
    }
    public void Return_Start_1(int i){
        Manager_Object_Car.get(i).setX(1200);
        Manager_Object_Car.get(i).setY(300);
        Manager_Object_Car.get(i).setRotate(0);
    }
    public void Return_2(int i){
        if (Manager_Object_Car.get(i).getX() <= 0 || Event == false){
            x++;
            Manager_Object_Car.get(i).setX(1200);
            Manager_Object_Car.get(i).setY(225);
            Manager_Object_Car.get(i).setRotate(0);
        }
    }
    public void Return_Start_2(int i){
        Manager_Object_Car.get(i).setX(1200);
        Manager_Object_Car.get(i).setY(225);
        Manager_Object_Car.get(i).setRotate(0);
    }
    public void Return_3(int i){
        if (( Manager_Object_Car.get(i).getX() <= 0 || Event == false)){
            x++;
            Manager_Object_Car.get(i).setX(1200);
            Manager_Object_Car.get(i).setY(45);
            Manager_Object_Car.get(i).setRotate(0);
        }
    }
    public void Return_Start_3(int i){
        Manager_Object_Car.get(i).setX(1200);
        Manager_Object_Car.get(i).setY(45);
        Manager_Object_Car.get(i).setRotate(0);
    }

    // Hiển thị điểm , ....
    public Text Lives(){
        Text text = new Text();
        text.setX(10);
        text.setY(750);
        text.setFont(Font.font ("Verdana"));
        text.setFont(new Font(32));
        text.setFill(Color.RED);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setText("Lives " + x);
            }
        };
        animationTimer.start();
        return text;
    }
    public Text Funds(){
        Text text = new Text();
        text.setX(200);
        text.setY(750);
        text.setFont(Font.font ("Verdana"));
        text.setFont(new Font(32));
        text.setFill(Color.ORANGE);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setText("Funds " + x);
            }
        };
        animationTimer.start();
        return text;
    }
    public Text Wave(){
        Text text = new Text();
        text.setX(400);
        text.setY(750);
        text.setFont(Font.font ("Verdana"));
        text.setFont(new Font(32));
        text.setFill(Color.GREEN);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setText("Wave : " + x + "/" + 30);
            }
        };
        animationTimer.start();
        return text;
    }
    //

}
