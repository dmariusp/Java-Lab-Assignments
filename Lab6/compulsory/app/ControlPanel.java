package compulsory.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    JFileChooser fileChooser = new JFileChooser();
    //create all buttons (Load, Reset, Exit)
// ...TODO

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        this.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); //border for config panel

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //add all buttons ...TODO
        //configure listeners for all buttons


        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Choose directory to save");
                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write(frame.drawingPanel.image, "PNG", fileChooser.getSelectedFile());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.drawingPanel.createOffscreenImage();
                frame.drawingPanel.repaint();
            }
        });


        loadBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Choose file to load");
                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToLoad = fileChooser.getSelectedFile();
                    try {
                        frame.drawingPanel.image = ImageIO.read(fileChooser.getSelectedFile());
                        frame.drawingPanel.repaint();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

//    private void save(ActionEvent e) {
//        try {
//            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
//        } catch (IOException ex) {
//            System.err.println(ex);
//        }
//    }
// ...TODO
    }
}

