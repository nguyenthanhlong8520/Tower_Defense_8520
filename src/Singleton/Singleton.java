package Singleton;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    private Media media = new Media("file:/home/nguyen/Desktop/Image/LOL_ms.mp3");
    private MediaPlayer mediaPlayer = new MediaPlayer(media);

    private Media media_defeat = new Media("file:/home/nguyen/Desktop/Image/Defeat.mp3");
    private MediaPlayer mediaPlayer_defeat = new MediaPlayer(media_defeat);


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

    public void Music_Defeat(){
        mediaPlayer_defeat.play();
    }

}
