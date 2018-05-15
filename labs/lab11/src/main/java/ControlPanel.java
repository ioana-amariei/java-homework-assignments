import javax.swing.*;
import javax.swing.text.JTextComponent;


public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Control panel"));
        this.frame = frame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        init();
    }

    private void init() {
        add(LookAndFeel.verticalSpace());

        classNameLabel.setFont(LookAndFeel.FONT_LOOK);
        classNameField.setFont(LookAndFeel.FONT_LOOK);
        textLabel.setFont(LookAndFeel.FONT_LOOK);
        textField.setFont(LookAndFeel.FONT_LOOK);
        createButton.setFont(LookAndFeel.FONT_LOOK);

        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);

        add(LookAndFeel.verticalSpace());
        add(createButton);
        add(LookAndFeel.verticalSpace());

        createButton.addActionListener(e -> {
            JComponent component = createDynamicComponent(classNameField.getText());
            setComponentText(component, textField.getText());
            frame.designPanel.addAtRandomLocation(component);
        });
    }

//    JButton, JLabel, JTextField, JPasswordField, JCheckBox, JColorChooser, JFileChooser
//    JPasswordField and JFormattedTextField JEditorPane
    private JComponent createDynamicComponent(String className) {
        Class inputClass = null;
        JComponent component = null;

        try {
            inputClass = Class.forName("javax.swing." + className);
            component = (JComponent) inputClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        component.setFont(LookAndFeel.FONT_LOOK);
        return component;
    }

    private void setComponentText(JComponent component, String text) {
        if(component instanceof JTextComponent){
            ((JTextComponent) component).setText(text);
            component.setForeground(LookAndFeel.COLOR_LOOK);
        }
    }
}