package create.image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Canvas extends JPanel {
    private final DrawingFrame frame;
    private BufferedImage image = new BufferedImage(1850, 1000, BufferedImage.TYPE_INT_ARGB);

    public Canvas(DrawingFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Canvas"));
        this.frame = frame;
        init();
        this.setLayout(new GridLayout(0, 1));
    }

    private void init() {
        this.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                drawShapeAt(e.getX(), e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public void drawShapeAt(int x, int y) {
        Graphics2D graphics = (Graphics2D) image.getGraphics();

        Random rand = new Random();
        int radius = rand.nextInt(300);
        int sides = rand.nextInt(15);

        RegularPolygon polygon = new RegularPolygon(x, y, radius,sides);

        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        graphics.fill(polygon);

        repaint();
    }

    public void drawRandomShape() {
        Random random = new Random();
        int randomX = random.nextInt(1850);
        int randomY = random.nextInt(1000);

        drawShapeAt(randomX, randomY);
    }
}
