package Screen_Text;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class S_Text {
    public int x;
    public int wave;
    public javafx.scene.text.Text Lives(){
        javafx.scene.text.Text text = new javafx.scene.text.Text();
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
    public javafx.scene.text.Text Funds(){
        javafx.scene.text.Text text = new javafx.scene.text.Text();
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
    public javafx.scene.text.Text Wave(){
        javafx.scene.text.Text text = new javafx.scene.text.Text();
        text.setX(400);
        text.setY(750);
        text.setFont(Font.font ("Verdana"));
        text.setFont(new Font(32));
        text.setFill(Color.GREEN);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setText("Wave : " + wave + "/" + 10);
            }
        };
        animationTimer.start();
        return text;
    }

    public void Change_X(){
        x ++;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
}
