/**
 * @author Birsan Ioana (cas. Amariei)
 * @author Gensthaler Octavian
 */

package visual.document.manager;

import catalog.Catalog;

import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
    DocumentForm form;
    CatalogTable table;
    ControlPanel control;
    Catalog catalog;

    public CatalogFrame() {
        super("Visual Document Manager");
        init();
        addComponents();
        this.pack();
    }
    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new DocumentForm(this);
        table = new CatalogTable(this);
        control = new ControlPanel(this);
        catalog = new Catalog();
    }

    private void addComponents(){
        add(form, BorderLayout.NORTH);
        form.add(new JSeparator(SwingConstants.VERTICAL));
        add(table, BorderLayout.CENTER);
        table.add(new JSeparator(SwingConstants.VERTICAL));
        add(control, BorderLayout.SOUTH);
        control.add(new JSeparator(SwingConstants.VERTICAL));
    }

}