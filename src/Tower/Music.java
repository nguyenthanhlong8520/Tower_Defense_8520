package Tower;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {
    private Media media_bullet = new javafx.scene.media.Media("file:/home/nguyen/Desktop/Image/bullet.mp3");
    private MediaPlayer mediaPlayer_Gun = new MediaPlayer(media_bullet);

    private Media media_bum = new javafx.scene.media.Media("file:/home/nguyen/Desktop/Image/Bum.mp3");
    private MediaPlayer mediaPlayer_bum = new MediaPlayer(media_bum);

    public Music() {

    }

    public void PLay_Shoot(){
        mediaPlayer_Gun.play();
    }

    public void Play_Bum(){
        mediaPlayer_bum.setStopTime(new Duration(1000000000));
        mediaPlayer_bum.play();
    }
}
