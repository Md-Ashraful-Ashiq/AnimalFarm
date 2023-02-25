package animalfarm;

import javax.swing.*;

public class Duck extends Animal {

    public Duck() {
        name = ElementEnum.DUCK;
        image = new ImageIcon("res/duck.gif");
        audio = "res/duck-quacking.wav";
        cost = 5;
        sellPrice = 8;
        initialHungerLevel = 3;
        harvestingAgeInMinutes = 2;
    }
}
