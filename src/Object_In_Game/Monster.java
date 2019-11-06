package Object_In_Game;

import javafx.scene.canvas.GraphicsContext;

public abstract class Monster {
    abstract void Render(GraphicsContext graphicsContext);
    abstract void Blood_bar(GraphicsContext graphicsContext);
    abstract void Move_Up();
    abstract void Move_Down();
    abstract void Move_Left();
    abstract void Move_Right();
    abstract void Rotate();
}
