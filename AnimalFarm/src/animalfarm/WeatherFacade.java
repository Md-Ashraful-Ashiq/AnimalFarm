package animalfarm;

import javax.swing.*;

public class WeatherFacade {

    Farm farm;
    Decoration tree, light, bush;
    Audio audio;

    public WeatherFacade(Farm farm, Decoration tree, Decoration light, Decoration bush, Audio audio) {
        this.farm = farm;
        this.tree = tree;
        this.light = light;
        this.bush = bush;
        this.audio = audio;
    }

    public void Sunny() {
        farm.setIsCloudy(false);
        farm.setIsRainy(false);
        farm.setIsWindy(false);
        farm.setIsNight(false);
        
        tree.setImage(new ImageIcon("res/tree.png"));
        bush.setImage(new ImageIcon("res/bush.png"));
        light.setImage(new ImageIcon("res/lamp_sun.png"));

        audio.stopRain();
        audio.stopNight();
        audio.stopWind();
        audio.playSun();
    }

    public void Cloudy() {
        farm.setIsCloudy(true);
        farm.setIsRainy(false);
        farm.setIsWindy(false);
        farm.setIsNight(false);
       
        tree.setImage(new ImageIcon("res/tree.png"));
        bush.setImage(new ImageIcon("res/bush.png"));
        light.setImage(new ImageIcon("res/lamp_sun.png"));

        audio.stopSun();
        audio.stopRain();
        audio.stopNight();
        audio.stopWind();
    }

    public void Windy() {
        farm.setIsCloudy(false);
        farm.setIsRainy(false);
        farm.setIsWindy(true);
        farm.setIsNight(false);

        tree.setImage(new ImageIcon("res/wind_tree.gif"));
        bush.setImage(new ImageIcon("res/wind_bush.gif"));
        light.setImage(new ImageIcon("res/lamp_sun.png"));

        audio.stopSun();
        audio.stopRain();
        audio.stopNight();
        audio.playWind();
    }

    public void Rainy() {
        farm.setIsCloudy(false);
        farm.setIsRainy(true);
        farm.setIsWindy(false);
        farm.setIsNight(false);

        tree.setImage(new ImageIcon("res/wind_tree.gif"));
        bush.setImage(new ImageIcon("res/wind_bush.gif"));
        light.setImage(new ImageIcon("res/lamp_night.png"));

        audio.stopSun();
        audio.stopWind();
        audio.stopNight();
        audio.playRain();
    }

    public void Night() {
        farm.setIsCloudy(false);
        farm.setIsRainy(false);
        farm.setIsWindy(false);
        farm.setIsNight(true);

        tree.setImage(new ImageIcon("res/tree.png"));
        bush.setImage(new ImageIcon("res/bush.png"));
        light.setImage(new ImageIcon("res/lamp_night.png"));
        
        audio.stopSun();
        audio.stopWind();
        audio.stopRain();
        audio.playNight();
    }
}
