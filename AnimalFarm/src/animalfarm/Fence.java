package animalfarm;

import javax.swing.*;

public class Fence extends Decoration {

    int counter;

    public Fence() {
        name = ElementEnum.FENCE;
        cost = 2;
    }

    public ImageIcon getFence(int counter) {
        this.counter = counter;
        switch (counter) {
            case 1:
                image = new ImageIcon("res/fence_front.png");
                break;
            case 2:
                image = new ImageIcon("res/fence_corner1.png");
                break;
            case 3:
                image = new ImageIcon("res/fence_corner2.png");
                break;
            case 4:
                image = new ImageIcon("res/fence_back.png");
                break;
            case 5:
                image = new ImageIcon("res/fence_corner3.png");
                break;
            case 6:
                image = new ImageIcon("res/fence_corner4.png");
                break;
            case 7:
                image = new ImageIcon("res/fence_left.png");
                break;
            case 8:
                image = new ImageIcon("res/fence_right.png");
                break;
        }
        return image;
    }
}
