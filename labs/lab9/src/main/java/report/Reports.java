package report;

import model.Rank;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

public class Reports {
    private static final StyleBuilder boldStyle         = stl.style().bold();
    private static final StyleBuilder boldCenteredStyle = stl.style(boldStyle)
                                        .setHorizontalAlignment(HorizontalAlignment.CENTER);
    private static final StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                                        .setBorder(stl.pen1Point())
                                        .setBackgroundColor(Color.LIGHT_GRAY);

    public void generatePDFReport(List<Rank> ranks, String title) throws DRException, FileNotFoundException {
        DynamicReports.report()
                .columns(
                        col.column("Album Name", "albumName", type.stringType()),
                        col.column("Artist Name", "artistName", type.stringType()),
                        col.column("Downloads", "downloads", type.integerType()),
                        col.column("Rating", "rating", type.floatType()),
                        col.column("Sales", "albumSales", type.integerType())
                )
                .setColumnTitleStyle(columnTitleStyle)
                .highlightDetailEvenRows()
                .title(cmp.text(title).setStyle(boldCenteredStyle))
                .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))
                .setDataSource(ranks)
                .show();
    }

    public void generateHTMLReport(List<Rank> ranks, String path, String title) throws DRException, FileNotFoundException {
        DynamicReports.report()
                .columns(
                        col.column("Album Name", "albumName", type.stringType()),
                        col.column("Artist Name", "artistName", type.stringType()),
                        col.column("Downloads", "downloads", type.integerType()),
                        col.column("Rating", "rating", type.floatType()),
                        col.column("Sales", "albumSales", type.integerType())
                )
                .setColumnTitleStyle(columnTitleStyle)
                .highlightDetailEvenRows()
                .title(cmp.text(title).setStyle(boldCenteredStyle))
                .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))
                .setDataSource(ranks)
                .toHtml(new FileOutputStream(path));
    }

    public void generateCSVReport(List<Rank> ranks, String path) throws DRException, FileNotFoundException {
        DynamicReports.report()
                .columns(
                        col.column("Album Name", "albumName", type.stringType()),
                        col.column("Artist Name", "artistName", type.stringType()),
                        col.column("Downloads", "downloads", type.integerType()),
                        col.column("Rating", "rating", type.floatType()),
                        col.column("Sales", "albumSales", type.integerType())
                )
                .setDataSource(ranks)
                .toCsv(new FileOutputStream(path));
    }

}
