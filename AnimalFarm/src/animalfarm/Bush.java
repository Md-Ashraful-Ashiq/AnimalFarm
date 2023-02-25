package animalfarm;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Bush extends Decoration implements Subject {
    private List<Observer> observers;

    public Bush() {
        name = ElementEnum.BUSH;
        image = new ImageIcon("res/bush.png");
        cost = 5;
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(image);
        }
    }
    
    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Bush{" + "observers=" + observers + '}';
    } 
}
