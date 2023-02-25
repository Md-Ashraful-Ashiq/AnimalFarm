package animalfarm;

import javax.swing.*;

public class Delete extends Decoration {

    public Delete() {
        name = ElementEnum.DELETE;
    }

    public ImageIcon getDelete() {
        image = new ImageIcon("res/delete.png");
        return image;
    }
}
