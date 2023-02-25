package animalfarm;

import javax.swing.*;

public class LightOnCommand implements Command {
    Decoration light;

    public LightOnCommand(Decoration light) {
        this.light = light;
    }    
    
    @Override
    public void execute() {
        light.setImage(new ImageIcon("res/lamp_night.png"));
    }
}
