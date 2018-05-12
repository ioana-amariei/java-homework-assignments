package report;

import model.Rank;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.exception.DRException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

public class Reports {

    public void generatePDFReport(List<Rank> ranks) throws DRException, FileNotFoundException {
        DynamicReports.report()
                .columns(
                        col.column("Album Name", "albumName", type.stringType()),
                        col.column("Artist Name", "artistName", type.stringType()),
                        col.column("Downloads", "downloads", type.integerType()),
                        col.column("Rating", "rating", type.floatType()),
                        col.column("Sales", "albumSales", type.integerType())
                )
                .setDataSource(ranks)
                .show();
    }

    public void generateHTMLReport(List<Rank> ranks, String path) throws DRException, FileNotFoundException {
        DynamicReports.report()
                .columns(
                        col.column("Album Name", "albumName", type.stringType()),
                        col.column("Artist Name", "artistName", type.stringType()),
                        col.column("Downloads", "downloads", type.integerType()),
                        col.column("Rating", "rating", type.floatType()),
                        col.column("Sales", "albumSales", type.integerType())
                )
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
