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

import static visual.document.manager.LookAndFeel.FONT_LOOK;
import static visual.document.manager.LookAndFeel.HORIZONTAL_SPACE;

public class DocumentForm extends JPanel {
    private final CatalogFrame frame;

    private final JLabel typeLabel = new JLabel("Type of document");
    private final JLabel titleLabel = new JLabel("Title of the document");
    private final JLabel pathLabel = new JLabel("Path in the local file system");
    private final JLabel yearLabel = new JLabel("Publication year");
    private final JLabel authorsLabel = new JLabel("Authors");

    private final JTextField typeField = new JFormattedTextField();
    private final JTextField titleField = new JFormattedTextField();
    private final JTextField pathField = new JFormattedTextField();
    private final JSpinner yearField = new JSpinner(new SpinnerNumberModel(1950, 1900, 2017, 1));
    private final JTextField authorsField = new JFormattedTextField();

    private final JButton addButton = new JButton("Add to repository");
    private final JButton printButton = new JButton("Display catalog");
    private final JButton clearButton = new JButton("Clear catalog table display");

    private final Box buttonBox = Box.createHorizontalBox();
    private int year;

    public DocumentForm(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Add document"));
        this.frame = frame;
        init();

        this.setLayout(new GridLayout(0,1));
    }

    private void init() {
        add(typeLabel);
        typeLabel.setFont(FONT_LOOK);
        add(typeField);
        typeField.setFont(FONT_LOOK);
        typeField.setForeground(Color.red);

        add(titleLabel);
        titleLabel.setFont(FONT_LOOK);
        add(titleField);
        titleField.setFont(FONT_LOOK);
        titleField.setForeground(Color.red);

        add(pathLabel);
        pathLabel.setFont(FONT_LOOK);
        add(pathField);
        pathField.setFont(FONT_LOOK);
        pathField.setForeground(Color.red);

        add(yearLabel);
        yearLabel.setFont(FONT_LOOK);
        add(yearField);
        yearField.setFont(FONT_LOOK);
        yearField.setForeground(Color.red);
        yearField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                year = (int) yearField.getValue();
            }
        });

        add(authorsLabel);
        authorsLabel.setFont(FONT_LOOK);
        add(authorsField);
        authorsField.setFont(FONT_LOOK);
        authorsField.setForeground(Color.red);
        authorsField.add(new JSeparator(SwingConstants.VERTICAL));

        buttonBox.add(addButton);
        addButton.setFont(FONT_LOOK);
        buttonBox.add(HORIZONTAL_SPACE);
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
        printButton.setFont(FONT_LOOK);
        buttonBox.add(HORIZONTAL_SPACE);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCatalog();
            }
        });

        buttonBox.add(clearButton);
        clearButton.setFont(FONT_LOOK);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideCatalog();
            }
        });

        add(buttonBox);
    }

    private void addDocumentToCatalog() throws IOException, ClassNotFoundException {
        List <String> parameters = new LinkedList <>();
        parameters.add(typeField.getText());
        parameters.add(titleField.getText());
        parameters.add(pathField.getText());
        parameters.add(String.valueOf(year));
        parameters.add(authorsField.getText());

        Command command = new AddCommand(frame.catalog, parameters);
        command.execute();
    }

    private void displayCatalog(){
        frame.table.printCatalog();
    }

    private void hideCatalog(){
        frame.table.hideCatalog();
    }
}
