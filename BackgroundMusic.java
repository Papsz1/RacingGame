import javax.sound.sampled.*;
import java.io.File;

public class BackgroundMusic {

    AudioInputStream inputMusic;
    Clip backgroundSong;

    public BackgroundMusic() {
        try {
            inputMusic = AudioSystem.getAudioInputStream(new File("src/song.wav").getAbsoluteFile());
            backgroundSong = AudioSystem.getClip();
            backgroundSong.open(inputMusic);
            backgroundSong.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception exception) {
            System.out.println("The music could not be loaded");
        }
    }
}
