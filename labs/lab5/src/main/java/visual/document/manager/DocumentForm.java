package visual.document.manager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentForm extends JPanel{
    private final CatalogFrame frame;
    private int year;

    JLabel titleLabel = new JLabel("Title of the document");
    JLabel pathLabel = new JLabel("Path in the local file system");
    JLabel yearLabel = new JLabel("Publication year");

    JTextField titleField = new JFormattedTextField();
    JTextField pathField = new JFormattedTextField();
    JSpinner yearField = new JSpinner(new SpinnerNumberModel(1950, 1900, 2017, 1));
    JButton addButton = new JButton("Add to repository");

    public DocumentForm(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Add document"));
        this.frame = frame;
        init();

        this.setLayout(new GridLayout(0,1));
    }

    private void init() {
        add(titleLabel);
        add(titleField);

        add(yearLabel);
        add(yearField);
        yearField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                year = (int) yearField.getValue();
            }
        });

        add(pathLabel);
        add(pathField);

        addButton.setSize(100,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDocument();
            }
        });
    }

    private void addDocument() {
        String document = titleField.getText() + " " + year + " " + pathField.getText() + "\n";
        frame.list.addDocument(document);
    }
}
