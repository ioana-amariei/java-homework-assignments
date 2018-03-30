package create.image;

import com.sun.corba.se.impl.orbutil.DenseIntMapImpl;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static create.image.LookAndFeel.*;

public class Toolbar extends JPanel {
    private final DrawingFrame frame;

    private JLabel sideLabel = new JLabel("Sides: ");
    private final JSpinner sideField = new JSpinner(new SpinnerNumberModel(4, 3, 15, 1));

    private JLabel radiusLabel = new JLabel("Radius: ");
    private final JSpinner radiusField = new JSpinner(new SpinnerNumberModel(2, 1, 10, 1));

    private JLabel shapeLabel = new JLabel("Shapes: ");
    private final JSpinner shapeField = new JSpinner(new SpinnerNumberModel(4, 3, 15, 1));

    private JButton drawButton = new JButton("Draw");
    private Dimension dimension = new Dimension(100, 30);


    public Toolbar(DrawingFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
        this.frame = frame;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        init();
    }

    private void init() {
        sideLabel.setFont(FONT_LOOK);
        sideField.setFont(FONT_LOOK);
        sideField.setMaximumSize(dimension);

        shapeLabel.setFont(FONT_LOOK);
        shapeField.setFont(FONT_LOOK);
        shapeField.setMaximumSize(dimension);

        radiusLabel.setFont(FONT_LOOK);
        radiusField.setFont(FONT_LOOK);
        radiusField.setMaximumSize(dimension);

        drawButton.setFont(FONT_LOOK);

        add(sideLabel);
        add(sideField);
        add(horizontalSpace());
        add(shapeLabel);
        add(shapeField);
        add(horizontalSpace());
        add(radiusLabel);
        add(radiusField);
        add(horizontalSpace());
        add(drawButton);

        drawButton.addActionListener(drawButtonActionListener());
    }

    private ActionListener drawButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.drawRandomShape();
            }
        };
    }
}
