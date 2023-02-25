package animalfarm;

import javax.swing.ImageIcon;

public class LightChild extends Decoration implements Observer{
    private Subject light;

    public LightChild(Subject light) {
        name = ElementEnum.LIGHT;
        cost = 25;
        image = new ImageIcon("res/lamp_sun.png");
        this.light = light;
        light.registerObserver(this);
    }
    
    @Override
    public void update(ImageIcon image) {
        this.image = image;
    }
}
