package compulsory.app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int height = screenSize.height;
    public static final int width = screenSize.width;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(900, 600));

        this.setSize(width, height); //for setting the object's size

        int xCoordinate = (screenSize.width - this.getWidth()) / 2; //in the centre of the screen
        int yCoordinate = (screenSize.height - this.getHeight()) / 2; //in the centre of the screen

        //Set the new frame's location
        this.setLocation(xCoordinate, yCoordinate);


        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);

        //invoke the layout manager
        pack();
    }
}
