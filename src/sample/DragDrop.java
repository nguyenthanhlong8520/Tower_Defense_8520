package sample;
import ImageInButton.CreateLinkImage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DragDrop extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

        @Override
        public void start(Stage primaryStage) throws Exception {
            Group root = new Group();
            Canvas canvas = new Canvas(1000,500);
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        final Button button1 = new Button();
        ImageView imageView = new ImageView("file:/home/nguyen/Desktop/Image/Tower1.png");
        button1.setGraphic(imageView);
        button1.setLayoutY(12);
        button1.setLayoutX(12);
        int x , y;
        button1.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                /* allow MOVE transfer mode */
                Dragboard db = button1.startDragAndDrop(TransferMode.MOVE);
                /* put a string on dragboard */
                db.getDragViewOffsetX();
                ClipboardContent content = new ClipboardContent();
                content.putString(button1.getText());
                db.setContent(content);
                event.consume();
            }
        });

        button1.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                Image image = new Image("file:/home/nguyen/Desktop/Image/233.png");
                graphicsContext.drawImage(image,event.getX(),event.getY());
                event.consume();
            }
        });

            root.getChildren().addAll(canvas,button1);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }

}





















