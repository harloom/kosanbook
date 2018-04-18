/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sound;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Hx-loom
 */
public class Hime {

    public void hime() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream file = AudioSystem.getAudioInputStream(Hime.class.getResource("link.wav"));
            clip.open(file);
            clip.start();
            Thread.sleep(7000);
            clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void baka() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream file = AudioSystem.getAudioInputStream(Hime.class.getResource("Sagiribaka.wav"));
            clip.open(file);
            clip.start();

//            clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void soundClick() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream file = AudioSystem.getAudioInputStream(Hime.class.getResource("click.wav"));
            clip.open(file);
            clip.start();

//            clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void soundErr() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream file = AudioSystem.getAudioInputStream(Hime.class.getResource("error.wav"));
            clip.open(file);
            clip.start();

//            clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
