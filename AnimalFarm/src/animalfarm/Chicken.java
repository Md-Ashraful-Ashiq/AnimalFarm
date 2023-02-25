package animalfarm;

import javax.swing.*;

public class Chicken extends Animal {

    public Chicken() {
        name = ElementEnum.CHICKEN;
        image = new ImageIcon("res/chicken.gif");
        audio = "res/chicken.wav";
        cost = 2;
        sellPrice = 3;
        initialHungerLevel = 2;
        harvestingAgeInMinutes = 1;
    }
}
