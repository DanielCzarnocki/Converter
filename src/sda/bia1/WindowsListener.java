package sda.bia1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}


//TODO Inne akkcje są zapisywane do loogu