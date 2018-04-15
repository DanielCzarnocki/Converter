package sda.bia1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Temperature Converter");
        jFrame.setSize(400, 400);
        WindowListener windowAction = new WindowsListener();

        jFrame.addWindowListener(windowAction);

        jFrame.add(new ConverterPanel());
        jFrame.pack();
        jFrame.setVisible(true);

    }
}
