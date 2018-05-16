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
import random.RandomAlbumData;
import random.RandomArtistData;
import random.RandomCriteriaData;
import report.Reports;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class Application {
    private static ArtistController artistController = new ArtistController();
    private static AlbumController albumController = new AlbumController();
    private static CriteriaController criteriaController = new CriteriaController();
    private static RankController rankController = new RankController();
    private static RandomAlbumData randomAlbum = new RandomAlbumData();
    private static RandomArtistData randomArtist = new RandomArtistData();
    private static RandomCriteriaData randomCriteria = new RandomCriteriaData();

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        try {
            createArtists(10);
            Database.commit();

            List<Artist> artists = artistController.findAll();
            for(Artist artist : artists){
                System.out.println(artist);
                createAlbums(2, artist.getId());
                Database.commit();
            }

            List<Album> albums = albumController.findAll();
            for (Album album : albums){
                createAndSaveChart(album.getId(),
                                    randomCriteria.getSales(),
                                    randomCriteria.getRating(),
                                    randomCriteria.getDownloads());
                Database.commit();
            }

            List<Criteria> criteria = criteriaController.findAll();
            for(Criteria criteria1 : criteria){
                System.out.println(criteria1);
            }

            Reports reports = new Reports();
            reports.generatePDFReport(rankController.findAllByDownloads(), "NUMBER OF DOWNLOADS");
            reports.generateHTMLReport(rankController.findAllByDownloads(), "downloads-report.html", "NUMBER OF DOWNLOADS");
            reports.generateCSVReport(rankController.findAllByDownloads(), "downloads-report.csv");

            reports.generatePDFReport(rankController.findAllBySales(), "ALBUM SALES");
            reports.generateHTMLReport(rankController.findAllBySales(), "sales-report.html", "ALBUM SALES");
            reports.generateCSVReport(rankController.findAllBySales(), "sales-report.csv");

            reports.generatePDFReport(rankController.findAllByRating(), "RATING");
            reports.generateHTMLReport(rankController.findAllByRating(), "rating-report.html", "RATING");
            reports.generateCSVReport(rankController.findAllByRating(), "rating-report.csv");

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAlbums(int howMany, int id) throws SQLException {
        int i = 0;
        while (i < howMany) {
            createAndSaveAlbum(randomAlbum.getRandomName(), id, randomAlbum.getRandomYear());
            i++;
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

    private static void createArtists(int howMany) throws SQLException {
        int i = 0;
        while (i < howMany) {
            createAndSaveArtist(randomArtist.getRandomName(), randomArtist.getRandomCountry());
            i++;
        }
    }

    private static void createAndSaveAlbum(String name, int artistId, int releaseYear) throws SQLException {
        Album album = new Album(name, artistId, releaseYear);
        albumController.save(album);
    }
}
