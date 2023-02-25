package animalfarm;

import javax.swing.*;

public class Barn extends Decoration {

    public Barn() {
        name = ElementEnum.BARN;
        image = new ImageIcon("res/barn.png");
        cost = 50;
    }
}
