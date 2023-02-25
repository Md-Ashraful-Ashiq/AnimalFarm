package animalfarm;

import javax.swing.*;

public class LightOffCommand implements Command {
    Decoration light;

    public LightOffCommand(Decoration light) {
        this.light = light;
    }    
    
    @Override
    public void execute() {
        light.setImage(new ImageIcon("res/lamp_sun.png"));
    }
}
