/**
 * @author Birsan Ioana (cas. Amariei)
 * @author Gensthaler Octavian
 */
package visual.document.manager;

import commands.AddCommand;
import commands.Command;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DocumentForm extends JPanel {
    private final CatalogFrame frame;

    JLabel typeLabel = new JLabel("Type of document");
    JLabel titleLabel = new JLabel("Title of the document");
    JLabel pathLabel = new JLabel("Path in the local file system");
    JLabel yearLabel = new JLabel("Publication year");
    JLabel authorsLabel = new JLabel("Authors");
    JTextField typeField = new JFormattedTextField();
    JTextField titleField = new JFormattedTextField();
    JTextField pathField = new JFormattedTextField();
    JSpinner yearField = new JSpinner(new SpinnerNumberModel(1950, 1900, 2017, 1));
    JTextField authorsField = new JFormattedTextField();
    JButton addButton = new JButton("Add to repository");
    JButton printButton = new JButton("Display catalog");

    Box buttonBox = Box.createHorizontalBox();
    private int year;

    public DocumentForm(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Add document"));
        this.frame = frame;
        init();

        this.setLayout(new GridLayout(0,1));
    }

    private void init() {
        add(typeLabel);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(typeField);
        typeField.setFont(new Font("Arial", Font.BOLD, 14));
        typeField.setForeground(Color.red);

        add(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleField);
        titleField.setFont(new Font("Arial", Font.BOLD, 14));
        titleField.setForeground(Color.red);

        add(pathLabel);
        pathLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(pathField);
        pathField.setFont(new Font("Arial", Font.BOLD, 14));
        pathField.setForeground(Color.red);

        add(yearLabel);
        yearLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(yearField);
        yearField.setFont(new Font("Arial", Font.BOLD, 14));
        yearField.setForeground(Color.red);
        yearField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                year = (int) yearField.getValue();
            }
        });

        add(authorsLabel);
        authorsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(authorsField);
        authorsField.setFont(new Font("Arial", Font.BOLD, 14));
        authorsField.setForeground(Color.red);

        buttonBox.add(addButton);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonBox.add(Box.createRigidArea(new Dimension(10,0)));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addDocumentToCatalog();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonBox.add(printButton);
        printButton.setFont(new Font("Arial", Font.BOLD, 14));
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCatalog();
            }
        });

        add(buttonBox);
    }

    private void addDocumentToCatalog() throws IOException, ClassNotFoundException {
        List <String> parameters = new LinkedList <>();
        parameters.add(typeField.getText());
        parameters.add(titleField.getText());
        parameters.add(pathField.getText());
        parameters.add(yearField.getValue().toString());
        parameters.add(authorsField.getText());

        Command command = new AddCommand(frame.catalog, parameters);
        command.execute();
    }

    private void displayCatalog(){
        frame.list.printCatalog(frame.catalog);
    }
}
