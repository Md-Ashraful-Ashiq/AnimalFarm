package animalfarm;

import javax.swing.*;

public class Cow extends Animal {

    public Cow() {
        name = ElementEnum.COW;
        image = new ImageIcon("res/cow.gif");
        audio = "res/cowmooing.wav";
        cost = 20;
        sellPrice = 30;
        initialHungerLevel = 5;
        harvestingAgeInMinutes = 6;
    }
}
