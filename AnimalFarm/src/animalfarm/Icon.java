package animalfarm;

import javax.swing.*;

public class Icon {

    private ImageIcon grass, cloudy, night, rain, dark, barn, menu;

    public Icon() {
        // Grass
        grass = new ImageIcon("res/farm.png");

        // Menu
        menu = new ImageIcon("res/side_menu.png");

        // Night
        night = new ImageIcon("res/night.png");

        // Cloudy
        cloudy = new ImageIcon("res/cloudy.png");

        // Rain
        rain = new ImageIcon("res/rain.gif");

        // Dark
        dark = new ImageIcon("res/dark.png");
    }

    public ImageIcon getGrass() {
        return grass;
    }

    public ImageIcon getMenu() {
        return menu;
    }

    public ImageIcon getBarn() {
        return barn;
    }

    public ImageIcon getRain() {
        return rain;
    }

    public ImageIcon getCloudy() {
        return cloudy;
    }

    public ImageIcon getNight() {
        return night;
    }

    public ImageIcon getDark() {
        return dark;
    }
}
