package create.image;

import javax.swing.*;
import java.awt.*;

import static create.image.LookAndFeel.*;


public class ControlPanel extends JPanel {
    private final DrawingFrame frame;

    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton resetButton = new JButton("Reset");


    public ControlPanel(DrawingFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Control panel"));
        this.frame = frame;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        init();
    }

    private void init() {
        saveButton.setFont(FONT_LOOK);
        loadButton.setFont(FONT_LOOK);
        resetButton.setFont(FONT_LOOK);

        add(saveButton);
        add(horizontalSpace());

        add(loadButton);
        add(horizontalSpace());

        add(resetButton);
    }
}
