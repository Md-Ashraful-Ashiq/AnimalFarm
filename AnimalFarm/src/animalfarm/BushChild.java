package animalfarm;

import javax.swing.ImageIcon;

public class BushChild extends Decoration implements Observer{
    private Subject bush;

    public BushChild(Subject bush) {
        name = ElementEnum.BUSH;
        cost = 5;
        image = new ImageIcon("res/bush.png");
        this.bush = bush;
        bush.registerObserver(this);
    }
    
    @Override
    public void update(ImageIcon image) {
        this.image = image;
    }
}
