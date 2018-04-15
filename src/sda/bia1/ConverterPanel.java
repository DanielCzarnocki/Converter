package sda.bia1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterPanel extends JPanel implements ActionListener {

    private JButton converterButtonToF;
    private JButton converterButtonToC;
    private JLabel celsiusLabel;
    private JLabel fahrentheitLabel;
    private JTextField inputFieldInF;
    private JTextField inputFieldInC;
    private final String COMMAND_TO_CELS = "Convert to C";
    private final String COMMAND_TO_FARH = "Convert to F";

    public ConverterPanel() {
        initLayout();
        initComponent();
    }

    private void initLayout() {
        GridLayout layout = new GridLayout(3, 2, 2, 2);
        setLayout(layout);
    }


    private void initComponent() {
        Icon icon = new ImageIcon("src/images/convert.png");
        converterButtonToF = new JButton(COMMAND_TO_FARH, icon);
        converterButtonToC = new JButton(COMMAND_TO_CELS, icon);
        celsiusLabel = new JLabel("Celsius");
        fahrentheitLabel = new JLabel("Fahrentheit");
        inputFieldInF = new JTextField(10);
        inputFieldInC = new JTextField(10);
        inputFieldInC.setToolTipText("Temp in Cels");

        converterButtonToF.addActionListener(this);
        converterButtonToC.addActionListener(this);

        add(inputFieldInC);
        add(celsiusLabel);
        add(converterButtonToF);
        add(converterButtonToC);
        add(inputFieldInF);
        add(fahrentheitLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (COMMAND_TO_FARH.equals(e.getActionCommand())) {
            convertToFahrenheit();
        }
        if (COMMAND_TO_CELS.equals(e.getActionCommand())){
            convertToCelsiusit();
        }
    }

    private void convertToCelsiusit() {
        String inputData = inputFieldInF.getText();
        try {
            Double inputFahr = Double.parseDouble(inputData);
            Double resultInCels = (inputFahr - 32)/1.8;
            inputFieldInC.setText(String.format("%.6s", resultInCels));
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Wrong Type",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convertToFahrenheit() {
        String inputData = inputFieldInC.getText();
        try {
            Double inputCel = Double.parseDouble(inputData);
            Double fahrtTemp = inputCel * 1.8 + 32;
            inputFieldInF.setText(String.format("%.6s", fahrtTemp));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Wrong Type",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
