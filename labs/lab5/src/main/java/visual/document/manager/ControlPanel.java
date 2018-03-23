/**
 * @author Birsan Ioana (cas. Amariei)
 * @author Gensthaler Octavian
 */

package visual.document.manager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final CatalogFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");

    public ControlPanel(CatalogFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(loadButton);
        add(saveButton);
    }
}