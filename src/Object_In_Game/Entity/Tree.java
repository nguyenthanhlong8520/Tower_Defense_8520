package Object_In_Game.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import javafx.scene.image.Image;

public class Tree extends Abt_Entity {

     Image tree = new Image("file:src/AssetsKit/tree.png");
    private  double x , y , width , height;
    private  GraphicsContext graphicsContext;

    public Tree(double x, double y, double width, double height , GraphicsContext graphicsContext) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.graphicsContext = graphicsContext;
    }

    public  void Draw_Tree_1(){
       // graphicsContext.drawImage(tree,581,190,112,112);
        graphicsContext.drawImage(tree,x,y,width,height);
    }

    public void Draw_Tree_2(){
       // graphicsContext.drawImage(tree,x,y,width,height);
        graphicsContext.drawImage(tree,43,110,112,112);
    }

    @Override
    public boolean Land_Tower() {
        return false;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
