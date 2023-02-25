package animalfarm;

import javax.swing.*;

public interface Element {

    ElementEnum getName();

    void setName(ElementEnum name);

    ImageIcon getImage();

    void setImage(ImageIcon icon);
}
