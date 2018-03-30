/**
 * @author Birsan Ioana (cas. Amariei)
 * @author Gensthaler Octavian
 */

package visual.document.manager;

import commands.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static visual.document.manager.LookAndFeel.FONT_LOOK;
import static visual.document.manager.LookAndFeel.HORIZONTAL_SPACE;
import static visual.document.manager.LookAndFeel.VERICAL_SPACE;


public class ControlPanel extends JPanel {
    private final CatalogFrame frame;

    private final JLabel pathLabel = new JLabel("Save to / Load from / Open");
    private final JTextField pathField = new JFormattedTextField();

    private final Box controlBox = Box.createHorizontalBox();
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton openButton = new JButton("Open");
    private final JButton reportButton = new JButton("Report");


    public ControlPanel(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Control panel"));
        this.frame = frame;

        init();
        this.setLayout(new GridLayout(0,1));
    }

    private void init() {
        add(pathLabel);
        pathLabel.setFont(FONT_LOOK);
        add(pathField);
        pathField.setFont(FONT_LOOK);
        pathField.setForeground(Color.red);

        controlBox.add(saveButton);
        saveButton.setFont(FONT_LOOK);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = Arrays.asList(pathField.getText());
                Command command = new SaveCommand(frame.catalog, parameters);

                try {
                    command.execute();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        controlBox.add(HORIZONTAL_SPACE);


        controlBox.add(loadButton);
        loadButton.setFont(FONT_LOOK);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = Arrays.asList(pathField.getText());
                Command command = new LoadCommand(parameters);
                try {
                    command.execute();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        controlBox.add(HORIZONTAL_SPACE);


        controlBox.add(openButton);
        openButton.setFont(FONT_LOOK);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                List<String> parameters = Arrays.asList(pathField.getText());
                Command command = new PlayCommand(frame.catalog, parameters);

                try {
                    command.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        controlBox.add(HORIZONTAL_SPACE);


        controlBox.add(reportButton);
        reportButton.setFont(FONT_LOOK);
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = new LinkedList <>();
                parameters = Arrays.asList("html", pathField.getText());
                Command command = new ReportCommand(frame.catalog, parameters);

                try {
                    command.execute();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        controlBox.add(VERICAL_SPACE);

        add(controlBox);
    }

}