package animalfarm;

import javax.swing.ImageIcon;

public class TreeChild extends Decoration implements Observer{
    private Subject tree;

    public TreeChild(Subject tree) {
        name = ElementEnum.TREE;
        cost = 20;
        image = new ImageIcon("res/tree.png");
        this.tree = tree;
        tree.registerObserver(this);
    }
    
    @Override
    public void update(ImageIcon image) {
        this.image = image;
    }
}
