package animalfarm;

import javax.swing.*;

public abstract class Decoration implements Element {

    ElementEnum name;
    ImageIcon image;
    int cost;

    CurrencySingleton currencySingleton;

    public Decoration() {
        currencySingleton = CurrencySingleton.getInstance();
    }

    public boolean canBeBought() {
        return currencySingleton.getCurrency() >= cost;
    }

    public void buy() {
        if (canBeBought()) {
            currencySingleton.setCurrency(currencySingleton.getCurrency() - cost);
        } else {
            System.out.println("Not enough money to buy this decoration");
        }
    }

    @Override
    public ElementEnum getName() {
        return name;
    }

    @Override
    public void setName(ElementEnum name) {
        this.name = name;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
