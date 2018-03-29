package visual.document.manager;

import documents.Document;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Set;

public class CatalogTable extends JTable {
    private final CatalogFrame frame;
    DefaultTableModel model = new DefaultTableModel(new String[]{"Title", "Path", "Year", "Author(s)"}, 0);
    JTable table = new JTable(model);

    public CatalogTable(CatalogFrame frame) {
        this.frame = frame;
        init();
        this.setModel(model);
        this.setLayout(new BorderLayout());
    }


    private void init() {
        table.setFont(new Font("Arial", Font.BOLD, 18));
        table.setRowHeight(30);
        table.setIntercellSpacing(new Dimension(0,5));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,1850,600);
        add(scrollPane);
    }

    public void printCatalog() {
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

    public void hideCatalog() {
        for (int row = model.getRowCount() - 1; row >= 0; row--){
            model.removeRow(row);
            System.out.println("Removed " + row);
        }
    }
}

