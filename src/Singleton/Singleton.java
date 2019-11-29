package Singleton;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    private Media media = new Media("file:/home/nguyen/Desktop/Image/LOL_ms.mp3");
    private MediaPlayer mediaPlayer = new MediaPlayer(media);

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

    public void Music(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mediaPlayer.setAutoPlay(true);
            }
        };
        animationTimer.start();
    }
}
