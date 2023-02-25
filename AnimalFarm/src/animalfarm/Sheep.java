package animalfarm;

import javax.swing.*;

public class Sheep extends Animal {

    public Sheep() {
        name = ElementEnum.SHEEP;
        image = new ImageIcon("res/sheep.gif");
        audio = "res/sheep.wav";
        cost = 10;
        sellPrice = 15;
        initialHungerLevel = 3;
        harvestingAgeInMinutes = 4;
    }
}
