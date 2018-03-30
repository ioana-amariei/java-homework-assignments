package create.image;

import javax.swing.*;
import java.awt.*;

public class LookAndFeel {
    public static final Font FONT_LOOK = new Font("Arial",Font.BOLD, 16);

    public static Component horizontalSpace() {
        return Box.createRigidArea(new Dimension(20, 0));
    }

    public static Component verticalSpace(){
        return Box.createRigidArea(new Dimension(0,10));
    }
}
