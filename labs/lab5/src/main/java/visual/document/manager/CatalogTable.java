package visual.document.manager;

import documents.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Set;

import static visual.document.manager.LookAndFeel.TABLE_COLUMN_NAMES;
import static visual.document.manager.LookAndFeel.TABLE_CONTENT_FONT;
import static visual.document.manager.LookAndFeel.TABLE_HEADER_FONT;

public class CatalogTable extends JTable {
    private final CatalogFrame frame;
    DefaultTableModel model = new DefaultTableModel(TABLE_COLUMN_NAMES,0);
    private JTable table = new JTable(model);

    public CatalogTable(CatalogFrame frame) {
        this.frame = frame;
        init();
        this.setModel(model);
        this.setLayout(new BorderLayout());
    }

    private void init() {
        table.setFont(TABLE_CONTENT_FONT);
        table.setRowHeight(30);
        table.setIntercellSpacing(new Dimension(0, 5));
        table.getTableHeader().setFont(TABLE_HEADER_FONT);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1850, 600);

        add(scrollPane);
    }

    public void printCatalog() {
        clear();

        Set <Document> documents = frame.catalog.getDocuments();
        for (Document document : documents) {
            Object[] data = new Object[4];
            data[0] = document.getTitle();
            data[1] = document.getPath();
            data[2] = document.getYear();
            data[3] = document.getAuthors();

            model.addRow(data);
        }
    }

    public void clear() {
        model.setRowCount(0);
    }
}


