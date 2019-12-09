package Screen_Text;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class S_Text {
    protected int lives = 30;
    protected int wave = 15;
    protected int funds = 3000;

    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public int getFunds() {
        return funds;
    }
    public void setFunds(int funds) {
        this.funds = funds;
    }
    public int getX() {
        return lives = 30;
    }
    public void setX(int x) {
        this.lives = x;
    }
    public int getWave() {
        return wave;
    }
    public void setWave(int wave) {
        this.wave = wave;
    }

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
                text.setText("Lives " + lives);
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
                text.setText("Funds " + funds);
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
                text.setText("Wave : " + wave + "/" + 15);
            }
        };
        animationTimer.start();
        return text;
    }

}
