package animalfarm;

import javax.swing.*;

public class Coop extends Decoration {

    public Coop() {
        name = ElementEnum.COOP;
        image = new ImageIcon("res/coop.png");
        cost = 10;
    }

    public ImageIcon getCoop() {
        return image;
    }
}
