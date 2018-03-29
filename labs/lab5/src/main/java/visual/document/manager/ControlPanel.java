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
import java.util.LinkedList;
import java.util.List;


public class ControlPanel extends JPanel {
    private final CatalogFrame frame;

    JLabel pathLabel = new JLabel("Save to / Load from / Open");
    JTextField pathField = new JFormattedTextField();

    Box controlBox = Box.createHorizontalBox();
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton openButton = new JButton("Open");
    JButton reportButton = new JButton("Report");


    public ControlPanel(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Control panel"));
        this.frame = frame;

        init();
        this.setLayout(new GridLayout(0,1));
    }

    private void init() {
        add(pathLabel);
        pathLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(pathField);
        pathField.setFont(new Font("Arial", Font.BOLD, 14));
        pathField.setForeground(Color.red);


        controlBox.add(saveButton);
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = new LinkedList <>();
                parameters.add(pathField.getText());
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
        controlBox.add(Box.createRigidArea(new Dimension(10,0)));


        controlBox.add(loadButton);
        loadButton.setFont(new Font("Arial", Font.BOLD, 14));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = new LinkedList <>();
                parameters.add(pathField.getText());
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
        controlBox.add(Box.createRigidArea(new Dimension(10,0)));


        controlBox.add(openButton);
        openButton.setFont(new Font("Arial", Font.BOLD, 14));
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                List<String> parameters = new LinkedList <>();
                parameters.add(pathField.getText());
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
        controlBox.add(Box.createRigidArea(new Dimension(10,0)));


        controlBox.add(reportButton);
        reportButton.setFont(new Font("Arial", Font.BOLD, 14));
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> parameters = new LinkedList <>();
                parameters.add("html");
                parameters.add(pathField.getText());
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
        controlBox.add(Box.createRigidArea(new Dimension(0,10)));

        add(controlBox);
    }

}