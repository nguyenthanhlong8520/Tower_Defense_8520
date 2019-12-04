package Singleton;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    private Media media = new Media("file:/home/nguyen/Desktop/Image/LOL_ms.mp3");
    private MediaPlayer mediaPlayer = new MediaPlayer(media);


    private Media media_bullet = new Media("file:/home/nguyen/Desktop/Image/bullet.mp3");
    private MediaPlayer mediaPlayer_Gun = new MediaPlayer(media_bullet);


    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void Music_Background(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mediaPlayer.setAutoPlay(true);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            }
        };
        animationTimer.start();
    }

    public void Music_Game_Over(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mediaPlayer_Gun.setAutoPlay(true);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            }
        };
        animationTimer.start();
    }

}
