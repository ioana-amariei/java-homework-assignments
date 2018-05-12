import controller.AlbumController;
import controller.ArtistController;
import config.Database;
import controller.CriteriaController;
import controller.RankController;
import model.Album;
import model.Artist;
import model.Criteria;
import model.Rank;
import net.sf.dynamicreports.report.exception.DRException;
import report.Reports;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Application {
    private static ArtistController artistController = new ArtistController();
    private static AlbumController albumController = new AlbumController();
    private static CriteriaController criteriaController = new CriteriaController();
    private static RankController rankController = new RankController();

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        try {
            createAndSaveArtist("Radiohead", "United Kingdom");
            createAndSaveArtist("Phoenix", "Romania");
            Database.commit();

            int phoenixId = artistController.findByName("Phoenix").getId();
            createAndSaveAlbum("Mugur de fluier", phoenixId, 1974);

            int radioheadId = artistController.findByName("Radiohead").getId();
            createAndSaveAlbum("OK Computer", radioheadId, 1997);
            createAndSaveAlbum("Kid A", radioheadId, 2000);
            createAndSaveAlbum("In Rainbows", radioheadId, 2007);
            Database.commit();

            int mugurId = albumController.findByName("Mugur de fluier").getId();
            createAndSaveChart(mugurId, 123, 4.5f, 1234);

            int kidId = albumController.findByName("Kid A").getId();
            createAndSaveChart(kidId, 200, 3.4f, 1000);
            Database.commit();

            Reports reports = new Reports();
            reports.generatePDFReport(rankController.findAllByDownloads(), "NUMBER OF DOWNLOADS");
            reports.generateHTMLReport(rankController.findAllByDownloads(), "downloads-report.html", "NUMBER OF DOWNLOADS");
            reports.generateCSVReport(rankController.findAllByDownloads(), "downloads-report.csv");

            reports.generatePDFReport(rankController.findAllBySales(), "ALBUM SALES");
            reports.generateHTMLReport(rankController.findAllByDownloads(), "sales-report.html", "ALBUM SALES");
            reports.generateCSVReport(rankController.findAllByDownloads(), "sales-report.csv");

            reports.generatePDFReport(rankController.findAllByRating(), "RATING");
            reports.generateHTMLReport(rankController.findAllByDownloads(), "rating-report.html", "RATING");
            reports.generateCSVReport(rankController.findAllByDownloads(), "rating-report.csv");

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private static void createAndSaveChart(int albumId, int albumSales, float rating, int downloads) throws SQLException {
        Criteria criteria = new Criteria(albumId, albumSales, rating, downloads);
        criteriaController.save(criteria);
    }

    private static void createAndSaveArtist(String name, String country) throws SQLException {
        Artist artist = new Artist(name, country);
        artistController.save(artist);
    }

    private static void createAndSaveAlbum(String name, int artistId, int releaseYear) throws SQLException {
        Album album = new Album(name, artistId, releaseYear);
        albumController.save(album);
    }
}
