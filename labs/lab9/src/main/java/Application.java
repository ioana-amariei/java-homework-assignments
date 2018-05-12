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

            for(Album album : albumController.findAll()){
                System.out.println(album);
            }

            int mugurId = albumController.findByName("Mugur de fluier").getId();
            createAndSaveChart(mugurId, 123, 4.5f, 1234);

            int kidId = albumController.findByName("Kid A").getId();
            createAndSaveChart(kidId, 200, 3.4f, 1000);
            Database.commit();

            System.out.println("\nChart by number of downloads");
            for(Rank rank : rankController.findAllByDownloads()){
                System.out.println(rank);
            }

            System.out.println("\nChart by number of sales");
            for(Rank rank : rankController.findAllBySales()){
                System.out.println(rank);
            }

            Reports reports = new Reports();
            reports.generatePDFReport(rankController.findAllByDownloads());
            reports.generateHTMLReport(rankController.findAllByDownloads(), "report.html");
            reports.generateCSVReport(rankController.findAllByDownloads(), "report.csv");

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
