package Main;
import ImageInButton.CreateLinkImage;
import Object_In_Game.Enemy;
import Screen_Text.Wave;
import Tower.Tower;
import Tower.MachineGunTower;
import Tower.SniperTower;
import Tower.Music;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import Screen_Text.S_Text;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Singleton.Singleton;
import Object_In_Game.CreateEnemy.CrEnemy;
import Object_In_Game.Entity.Abt_Entity;
import Object_In_Game.Entity.Road;
import Object_In_Game.Entity.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main_Test_2 extends Application {
    boolean Event = false;
    int Index_Map = 0 , Index_Coordinates = 0 ;
    int M_i = 0 ;  // i đại diện cho monster thứ bao nhiêu , ví dụ monster thứ nhất : Manager_Object_Car.get(0);
    long timeOfLastFrameSwitch = 0 ;
    Button buttonMainMenu, buttonPlay_Start , buttonNext_Level, buttonMap_1, buttonTower , button_Sell
            , button_cancelGame , button_pause ;
    Scene scene_Play , scene_Background_1 , scene_gameOver;
    Group Root_Menu , Root_BackGround_1 , Root_gameOver;
    double Mouse_x , Mouse_Y , Tower_X , Tower_Y ;
    S_Text text = new S_Text() ;
    Wave wave = new Wave() ;
    CreateLinkImage createLinkImage = new CreateLinkImage() ;
    Canvas canvas ;
    BackGround Background;
    CrEnemy crEnemy = new CrEnemy();
    Abt_Entity abt_entity;
    Tree tree1 ;
    Tree tree2;

    public static void main(String[] args) {
        launch(args);
    }

    GraphicsContext graphicsContext;
    List<Enemy> Manager_Enemy = new ArrayList<>(); // tạo một danh sách các đối tượng kiểu Monster_car.
    List<Tower> Manager_towers = new ArrayList<>(); // danh sách đối tượng tháp;
    List<Integer> integers = new ArrayList<>(); // Mảng số nguyên

    @Override
    public void start(Stage primaryStage) throws Exception {

        canvas = new Canvas(1400, 900);

        graphicsContext = canvas.getGraphicsContext2D();
        Background = new BackGround();
        // chọn bản đồ 1
        Button_Choice_Menu(primaryStage);
        primaryStage.setScene(scene_Play);
        primaryStage.show();
        Update_Match(graphicsContext,primaryStage);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
              //  Singleton.getInstance().Music_Background();
            }
        };
        animationTimer.start();

    }

    public void Match_Map_1(Stage primaryStage){
        // nút ấn NextLevel
        buttonNext_Level = new Button();
        buttonNext_Level.setGraphic(createLinkImage.CreateImage_NextLevel());
        buttonNext_Level.setLayoutX(1150);
        buttonNext_Level.setLayoutY(280);
        buttonNext_Level.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Manager_Enemy.isEmpty() && text.getWave() >= 1){
                   try {
//                       Music music = new Music();
//                       music.Music_minions();
                   }catch (Exception e){}
//                    Music music = new Music();
//                    music.Music_minions();
                    wave.Rise_Wave(); // Tăng wave.
                    Limit_Monster(); // Thêm monster vào mảng.
                }
            }
        });

        //  Sell tower
        button_Sell = new Button();
        button_Sell.setGraphic(createLinkImage.Create_Sell());
        button_Sell.setLayoutX(1150);
        button_Sell.setLayoutY(400);
        button_Sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Manager_towers.size() != 0){
                    text.setFunds(text.getFunds() + 20);
                    Manager_towers.remove(0);
                }
            }
        });
        //

        //  Nút play bắt đầu cho xe chạy.
        buttonPlay_Start = new Button();
        buttonPlay_Start.setGraphic(createLinkImage.CreateImagePlay());
        buttonPlay_Start.setLayoutX(1150);
        buttonPlay_Start.setLayoutY(580);
        buttonPlay_Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (wave.getWave() == 0){
//                    Music music = new Music();
//                    music.Music_minions();
                    wave.setWave(1);
                    for (int i = 0 ; i < wave.Limit_Monster() - 1; i++){
                        Manager_Enemy.add(crEnemy.Create_Enemy_Red(wave.Speed(),wave.Blood(),graphicsContext));
                    }
                    Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
                }
                Event = true;
            }
        });

        // Khởi tạo nút MainMenu và xử lý sự kiện .
        buttonMainMenu = new Button();
        buttonMainMenu.setGraphic(createLinkImage.Create_MainMenu());
        buttonMainMenu.setLayoutX(1150);
        buttonMainMenu.setLayoutY(650);

        Root_BackGround_1 = new Group(text.Lives(), text.Funds(), text.Wave());
        Root_BackGround_1.getChildren().addAll(canvas,buttonMainMenu,buttonPlay_Start,buttonNext_Level,
                Button_Tower(),button_Sell, Button_Tower_Rocket1());
        scene_Background_1 =  new Scene(Root_BackGround_1,1400,800);
        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene_Play);
                Event = false;
                // khi event = false delete all object .
                for (int j = 0; j < Manager_Enemy.size() ; j++){
                    Delete_Object(j);
                }
            }
        });
        //
        primaryStage.setScene(scene_Background_1);
    }

    public void Update_Match(GraphicsContext gc,Stage primaryStage) throws InterruptedException {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update_Wave();
                // Khởi tạo hàm vẽ background Game và nhân vật.
                BackGround Obj = new BackGround();
                if (Index_Map == 1){
                    Obj.draw_Background_Match_1(gc);
                    tree1= new Tree(581,190,112,112,graphicsContext);
                    tree1.Draw_Tree_1();
                    tree2 = new Tree(43,110,112,112,graphicsContext);
                    tree2.Draw_Tree_2();
                    if (Event == true  ){
                        Render();
                        if( System.nanoTime() - timeOfLastFrameSwitch > (2000000000)  && M_i < Manager_Enemy.size()){
                            integers.add(M_i++);
                            timeOfLastFrameSwitch = System.nanoTime();
                        }
                        for ( int i = 0 ; i < integers.size() ; i++ ){
                                Monster_Update_Move(i);
                        }
                        for (int i = 0; i < Manager_Enemy.size() ; i++){
                            try {
                                if (Manager_Enemy.get(i).getHealth() < 0){
                                    Delete_Object(i);
                                    text.setFunds(text.getFunds() + 10);
                                }
                                if (Manager_Enemy.get(i).getX() < 0){
                                    Delete_Object(i);
                                    text.setLives(text.getLives() - 1);
                                }
                            }catch (Exception e){}
                            try {
                                gameOver(primaryStage);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    Obj.draw_Background_GREEN(gc);
                }
            }
        };
        animationTimer.start();
    }

    // Ham` render chung .
    public void Render(){
        Manager_Enemy.forEach(g->g.Render());
        Manager_Enemy.forEach(g->g.Blood_bar(Manager_Enemy));
    }
    //  Enemy Map_1
    public void Monster_Update_Move(int i){
        if (Manager_Enemy.get(i).getX() > 610 ){ // Nếu xObject2 lớn nhỏ hơn đoạn rẽ thứ nhất
            Manager_Enemy.get(i).Move_Left();
        }
        else if (Manager_Enemy.get(i).getX() == 610 && Manager_Enemy.get(i).getY() < 430){ // nếu dừng ở đoạn rẽ thứ nhất
            Manager_Enemy.get(i).Move_Down();
            Manager_Enemy.get(i).setRotate(-90);
        }
        else if (Manager_Enemy.get(i).getX() > 350 && Manager_Enemy.get(i).getY() == 430){ // di chuyen sang PHAI
            Manager_Enemy.get(i).Move_Left(); // di sang trai
            Manager_Enemy.get(i).setRotate(0);
        }
        else if (Manager_Enemy.get(i).getX() == 350 && Manager_Enemy.get(i).getY() > 150){
            Manager_Enemy.get(i).Move_Up(); // di len
            Manager_Enemy.get(i).setRotate(90);
        }
        else if ( Manager_Enemy.get(i).getX() > 150 && Manager_Enemy.get(i).getY() == 150){
            Manager_Enemy.get(i).Move_Left(); //di sang trai
            Manager_Enemy.get(i).setRotate(0);
        }
        else if (Manager_Enemy.get(i).getX() == 150 && Manager_Enemy.get(i).getY() < 360 ){
            Manager_Enemy.get(i).Move_Down(); // di xuong
            Manager_Enemy.get(i).setRotate(-90);
        }
        else if (Manager_Enemy.get(i).getX() > -90 && Manager_Enemy.get(i).getY() == 360){
            Manager_Enemy.get(i).Move_Left(); // di sang trai
            Manager_Enemy.get(i).setRotate(0);
        }
    }
    // Tạo Tower
    public Tower Create_Tower(double x , double y){
        Tower tower = new MachineGunTower(x,y,90,85,Root_BackGround_1,graphicsContext);
        return tower;
    }
    // Tower rocket1
    public Tower Create_Tower_Rocket1(double x , double y){
        Tower tower = new SniperTower(x,y,90,250,Root_BackGround_1,graphicsContext);
        return tower;
    }
    // Rise_Wave.
    public void update_Wave(){
        text.setWave(wave.getWave());
    }
    public void Limit_Monster(){
        if( wave.getWave() == 2 ){
            for (int i = 0 ; i < wave.Limit_Monster() ; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Yellow(wave.Speed(),wave.Blood(),graphicsContext));
            }
        }
        else if (wave.getWave() == 3 || wave.getWave() == 6){
            for (int i = 0 ; i < wave.Limit_Monster() - 1 ; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Blue(wave.Speed(),wave.Blood(),graphicsContext));
            }
            Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
        }
        else if (wave.getWave() == 7){
            for (int i = 0 ; i < wave.Limit_Monster() - 3; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Red(wave.Speed(),wave.Blood(),graphicsContext));
            }
            for (int i = 0 ; i <  3; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
            }
        }
        else if (wave.getWave() == 5){
            for (int i = 0 ; i < wave.Limit_Monster() - 2; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Yellow(wave.Speed(),wave.Blood(),graphicsContext));
            }
            Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
            Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
        }
        else {
            for (int i = 0 ; i < wave.Limit_Monster() - 4; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Yellow(wave.Speed(),wave.Blood(),graphicsContext));
            }
            for (int i = 0 ; i < 4; i++ ){
                Manager_Enemy.add(crEnemy.Create_Enemy_Planes(wave.Speed(),wave.Blood(),graphicsContext));
            }
        }
    }
    public Scene Button_Choice_Menu( Stage primaryStage){
        buttonMap_1 = new Button();
        buttonMap_1.setGraphic(createLinkImage.CreateImage_Map1());
        buttonMap_1.setLayoutX(600);
        buttonMap_1.setLayoutY(450);
        buttonMap_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Index_Map = 1;
                Index_Coordinates = 1;
                Match_Map_1(primaryStage);
            }
        });
        Root_Menu = new Group();
        Root_Menu.getChildren().addAll( Background.drawBackground_Wait(graphicsContext),buttonMap_1); // Background Màn hình chờ .
        scene_Play = new Scene( Root_Menu ,1400,700 ) ;
        return scene_Play;
    }
    //
    public Button Button_Tower(){
        buttonTower = new Button(); // button để chọn tháp.
        buttonTower.setGraphic(createLinkImage.CreateImage_Tower());
        buttonTower.setLayoutX(1125);
        buttonTower.setLayoutY(190);
        buttonTower.setOnMouseDragged(e -> { // trả về tọa độ x , y hiện tại của con trỏ chuột
            Mouse_x = e.getSceneX();
            Mouse_Y = e.getSceneY();
        });
        buttonTower.setOnMouseReleased(e -> {
            // gán như vậy để lấy được vị trí cuối cùng (kiểu như khi ko kéo nữa thì lấy tọa độ ấy để đặt tháp).
            Tower_X = Mouse_x;
            Tower_Y = Mouse_Y;
            abt_entity = new Road(Tower_X,Tower_Y,0,0);
            if (abt_entity.Land_Tower() == true && text.getFunds() - 100 >= 0) { // nếu ko trên đường thị đặt
                Manager_towers.add(Create_Tower(Tower_X, Tower_Y)); // thêm 1 tower mới vào mảng .
                text.setFunds(text.getFunds() - 100); // Nếu đủ tiền thì được đăt.
            }
        });
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                    for (int i = 0; i < Manager_towers.size() ; i++){  // liên tục render các tháp trong mảng + xoay.
                        Manager_towers.get(i).Render();
                        // bst fsu tim khóng cach ngan nhat
                        if (Manager_Enemy.size() != 0){
                            for (int j = 0; j < Manager_towers.size() ; j++){
                                double shortestDistance = 1000;
                                Point2D tower = new Point2D(Manager_towers.get(i).getX(), Manager_towers.get(i).getY());
                                for (int k = 0; k < Manager_Enemy.size() ; k++){
                                    Point2D enemy = new Point2D(Manager_Enemy.get(k).getX(), Manager_Enemy.get(k).getY());
                                    while (enemy.distance(tower) < shortestDistance && enemy.distance(tower) < Manager_towers.get(i).getRange()) {
                                        shortestDistance = enemy.distance(tower);
                                        Manager_towers.get(i).Rotate(Manager_Enemy.get(k).getX(), Manager_Enemy.get(k).getY(), Manager_Enemy);
                                    }
                                }
                            }
                        }
                    }
                }
        };
        animationTimer.start();
        return buttonTower;
    }
    //
    public Button Button_Tower_Rocket1(){
        buttonTower = new Button(); // button để chọn tháp.
        buttonTower.setGraphic(createLinkImage.CreateImage_Tower_Rocket1());
        buttonTower.setLayoutX(1225);
        buttonTower.setLayoutY(190);
        buttonTower.setOnMouseDragged(e -> { // trả về tọa độ x , y hiện tại của con trỏ chuột
            Mouse_x = e.getSceneX();
            Mouse_Y = e.getSceneY();
        });
        buttonTower.setOnMouseReleased(e -> {
            // gán như vậy để lấy được vị trí cuối cùng (kiểu như khi ko kéo nữa thì lấy tọa độ ấy để đặt tháp).
            Tower_X = Mouse_x;
            Tower_Y = Mouse_Y;
            abt_entity = new Road(Tower_X,Tower_Y,0,0);
            if (abt_entity.Land_Tower() == true && text.getFunds() - 150 >= 0) { // nếu ko trên đường thị đặt
                Manager_towers.add(Create_Tower_Rocket1(Tower_X, Tower_Y)); // thêm 1 tower mới vào mảng .
                text.setFunds(text.getFunds() - 150); // Nếu đủ tiền thì được đăt.
            }
        });
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (int i = 0; i < Manager_towers.size() ; i++){  // liên tục render các tháp trong mảng + xoay.
                   // Manager_towers.get(i).Render();
                    // bst fsu tim khóng cach ngan nhat
                    if (Manager_Enemy.size() != 0){
                        for (int j = 0; j < Manager_towers.size() ; j++){
                            double shortestDistance = 1000;
                            Point2D tower = new Point2D(Manager_towers.get(i).getX(), Manager_towers.get(i).getY());
                            for (int k = 0; k < Manager_Enemy.size() ; k++){
                                Point2D enemy = new Point2D(Manager_Enemy.get(k).getX(), Manager_Enemy.get(k).getY());
                                while (enemy.distance(tower) < shortestDistance && enemy.distance(tower) < Manager_towers.get(i).getRange()) {
                                    shortestDistance = enemy.distance(tower);
                                    Manager_towers.get(i).Rotate(Manager_Enemy.get(k).getX(), Manager_Enemy.get(k).getY(), Manager_Enemy);
                                }
                            }
                        }
                    }
                }
            }
        };
        animationTimer.start();
        return buttonTower;
    }
    // xoa doi tuong
    public void Delete_Object(int i){
        // giảm các chỉ số của mảng để xóa đối tượng.
        Manager_Enemy.remove(i);
        integers.remove(i);
        M_i --;
    }
    //
    public void gameOver(Stage primaryStage){
        if (text.getLives() <= 0){
           // Singleton.getInstance().Music_Defeat();
            while(Manager_Enemy.size() != 0){
                for (int i = 0; i< Manager_Enemy.size() ; i++){
                    Manager_Enemy.remove(i);
                }
            }
            button_cancelGame = new Button();
            button_cancelGame.setGraphic(createLinkImage.Cancel());
            button_cancelGame.setLayoutX(600);
            button_cancelGame.setLayoutY(500);
            button_cancelGame.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    primaryStage.close();
                }
            });
            Event = false; // game dừng.
            Root_gameOver = new Group();
            Root_gameOver.getChildren().addAll(canvas,Background.Game_Over(graphicsContext), button_cancelGame);
            scene_gameOver = new Scene(Root_gameOver,1400,700);
            primaryStage.setScene(scene_gameOver);
        }
    }
}




