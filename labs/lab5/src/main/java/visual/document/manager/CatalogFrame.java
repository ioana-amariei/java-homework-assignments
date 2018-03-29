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
    CatalogList list;
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
        list = new CatalogList();
        control = new ControlPanel(this);
        catalog = new Catalog();
    }

    private void addComponents(){
        add(form, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }

}