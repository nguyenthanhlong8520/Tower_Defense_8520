package Object_In_Game;

import javafx.scene.image.Image;

public abstract class Object_In_Game {
    int x ,y , health , speed;


    public abstract int getValue_X();
    public abstract int getValue_Y();
    public abstract int getSpeed();
    public abstract Image Create_Object(int x);
    public abstract Image Create_Health(int x);
}
