package animalfarm;

public class LightsControl {
    Command slot;

    public LightsControl() {
    }
    
    public void setCommand(Command command) {
        slot = command;
    }
    
    public void buttonWasPressed() {
        slot.execute();
    }
}
