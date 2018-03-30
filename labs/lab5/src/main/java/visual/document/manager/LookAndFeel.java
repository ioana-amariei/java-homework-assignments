package visual.document.manager;

import javax.swing.*;
import java.awt.*;

public class LookAndFeel {
    public static final Font FONT_LOOK = new Font("Arial",Font.BOLD, 16);
    public static final Component HORIZONTAL_SPACE = Box.createRigidArea(new Dimension(10,0));
    public static final Component VERICAL_SPACE = Box.createRigidArea(new Dimension(0,10));
    public static final Font TABLE_HEADER_FONT = new Font("Arial", Font.BOLD, 20);
    public static final Font TABLE_CONTENT_FONT = new Font("Arial", Font.BOLD, 18);
    public static final String[] TABLE_COLUMN_NAMES = {"Title", "Path", "Year", "Author(s)"};
}
