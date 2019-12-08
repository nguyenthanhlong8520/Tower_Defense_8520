package Object_In_Game.CreateEnemy;

import Object_In_Game.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CrEnemy {
    public Enemy Create_Enemy_Red(int speed , int blood, GraphicsContext graphicsContext){
        Image image = new Image("file:src/AssetsKit/233.png");
        Enemy enemy_car = new Enemy_Car_Red(image,1200,300,0,speed,blood,90,graphicsContext);
        return enemy_car;
    }
    public Enemy Create_Enemy_Blue(int speed , int blood, GraphicsContext graphicsContext){
        Image image = new Image("file:src/AssetsKit/237.png");
        Enemy enemy_car = new Enemy_Car_Blue(image,1200,300,0,speed,blood,90,graphicsContext);
        return enemy_car;
    }

    public Enemy Create_Enemy_Yellow(int speed , int blood, GraphicsContext graphicsContext){
        Image image = new Image("file:src/AssetsKit/231.png");
        Enemy enemy_car = new Enemy_Car_Yellow(image,1200,300,0,speed,blood,90,graphicsContext);
        return enemy_car;
    }

    public Enemy Create_Enemy_Planes(int speed , int blood, GraphicsContext graphicsContext){
        Image image = new Image("file:src/AssetsKit/planes.png");
        Enemy enemy_car = new Enemy_Planes(image,1200,300,0,speed,blood,90,graphicsContext);

        return enemy_car;
    }
}
