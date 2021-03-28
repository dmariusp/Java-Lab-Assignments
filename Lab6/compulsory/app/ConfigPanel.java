package compulsory.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    public int size;
    final MainFrame frame;
    public Color color;
    JLabel label; // we’re drawing regular polygons
    static JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        this.setBorder(BorderFactory.createDashedBorder(Color.black)); //layout
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); //border for config panel

        var sizeInputLabel = new JLabel("Enter size:");
        sizeInputLabel.setFont(new Font("Helvetica", Font.BOLD, 19));

        var sizeInputField = new JTextField("Write size here", 20);
        sizeInputField.setFont(new Font("Helvetica", Font.BOLD, 19));
        sizeInputField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

        sizeInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = Integer.parseInt(sizeInputField.getText());
            }
        });

        //create the label and the spinner
        var sidesLabel = new JLabel("Number of sides:");
        sidesLabel.setFont(new Font("Helvetica", Font.BOLD, 19));

        sidesField = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        sidesField.setValue(6); //default number of sides
        sidesField.setFont(new Font("Helvetica", Font.BOLD, 19));

        //create the colorCombo, containing the values: Random and Black
        var colorLabel = new JLabel("Set colour of the shape:");
        colorLabel.setFont(new Font("Helvetica", Font.BOLD, 19));
        String[] colours = {"Random", "Black"};
        var colorCombo = new JComboBox(colours);

// ...TODO
        add(sizeInputLabel);
        add(sizeInputField);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorLabel);
        add(colorCombo);
    }
}
