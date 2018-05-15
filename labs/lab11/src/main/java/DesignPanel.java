import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W = 800, H = 600;
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }

    public void addAtRandomLocation(JComponent component) {
        Random random = new Random();

        int xAxis = random.nextInt(W);
        int yAxis = random.nextInt(H);
        int width = component.getPreferredSize().width;
        int height = component.getPreferredSize().height;

        component.setBounds(xAxis, yAxis, width, height);
        component.setToolTipText(component.getClass().getName());
        this.add(component);
        frame.repaint();
    }
}