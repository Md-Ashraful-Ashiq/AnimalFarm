package animalfarm;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTWindow extends Frame {
    public void init(String title) {
        setTitle(title);
        setSize(1000, 680);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}