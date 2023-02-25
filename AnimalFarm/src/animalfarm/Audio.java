package animalfarm;

import java.io.*;
import javax.sound.sampled.*;

public class Audio {

    File rain, wind, night, sun;
    AudioInputStream rainStream, windStream, nightStream, sunStream;
    Clip rainClip, windClip, nightClip, sunClip;

    public Audio() {
        try {
            rain = new File("res/rain.wav");
            rainStream = AudioSystem.getAudioInputStream(rain);
            rainClip = AudioSystem.getClip();
            rainClip.open(rainStream);

            wind = new File("res/wind.wav");
            windStream = AudioSystem.getAudioInputStream(wind);
            windClip = AudioSystem.getClip();
            windClip.open(windStream);

            night = new File("res/night.wav");
            nightStream = AudioSystem.getAudioInputStream(night);
            nightClip = AudioSystem.getClip();
            nightClip.open(nightStream);

            sun = new File("res/birds.wav");
            sunStream = AudioSystem.getAudioInputStream(sun);
            sunClip = AudioSystem.getClip();
            sunClip.open(sunStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playRain() {
        try {
            rainClip.start();
            rainClip.loop(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopRain() {
        rainClip.stop();
    }

    public void playWind() {
        try {
            windClip.start();
            windClip.loop(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopWind() {
        windClip.stop();
    }

    public void playNight() {
        try {
            nightClip.start();
            nightClip.loop(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopNight() {
        nightClip.stop();
    }

    public void playSun() {
        try {
            sunClip.start();
            sunClip.loop(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopSun() {
        sunClip.stop();
    }
}
