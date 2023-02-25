package animalfarm;

import javax.swing.*;

public class Pond extends Decoration {

    public Pond() {
        name = ElementEnum.POND;
        image = new ImageIcon("res/pond.png");
        cost = 40;
    }  
}
