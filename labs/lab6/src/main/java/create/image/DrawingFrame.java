package create.image;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {
    Toolbar toolbar;
    Canvas canvas;
    ControlPanel control;

    public DrawingFrame() {
        super("Create images");
        init();
        addComponents();
        this.pack();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new Canvas(this);
        toolbar = new Toolbar(this);
        control = new ControlPanel(this);
    }

    private void addComponents() {
        add(toolbar, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }
}
