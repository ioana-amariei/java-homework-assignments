import controller.AlbumController;
import controller.ArtistController;
import controller.CriteriaController;
import controller.RankController;
import entity.Album;
import entity.Artist;
import entity.Criteria;
import entity.Rank;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AlbumManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    private static final ArtistController artistController = new ArtistController(emf);
    private static final AlbumController albumController = new AlbumController(emf);
    private static final CriteriaController criteriaController = new CriteriaController(emf);
    private static final RankController rankController = new RankController(emf);

    public static void main(String args[]) throws SQLException {
        new AlbumManager().run();
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command:");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "create-artist":
                    createArtist(params[1]); //the artist name
                    break;
                case "create-album":
                    createAlbum(params[1], params[2]); //the album name and the artist name
                    break;
                case "list-albums":
                    listAlbums(params[1]); //the artist name
                    break;
                case "create-criteria":
                    createCriteria(params[1], params[2], params[3], params[4]); // album name, sales, rating, downloads
                    break;
                case "list-ratings":
                    listRatings();
                    break;
                case "list-sales":
                    listSales();
                    break;
                case "list-downloads":
                    listDownloads();
                    break;
            }
        }
    }

    private void listDownloads() throws SQLException {
        System.out.println("\n-----------------------");
        System.out.println("Albums ordered by downloads");
        System.out.println("-----------------------\n");
        List<Rank> downloadRanks = rankController.findAllByDownloads();
        for(Rank rank : downloadRanks){
            System.out.println(rank);
        }
    }

    private void listSales() throws SQLException {
        System.out.println("\n-----------------------");
        System.out.println("Albums ordered by sales");
        System.out.println("-----------------------\n");
        List<Rank> saleRanks = rankController.findAllBySales();
        for(Rank rank : saleRanks){
            System.out.println(rank);
        }
    }

    private void listRatings() throws SQLException {
        System.out.println("\n-----------------------");
        System.out.println("Albums ordered by rating");
        System.out.println("-----------------------\n");
        List<Rank> ratingRanks = rankController.findAllByRating();
        for(Rank rank : ratingRanks){
            System.out.println(rank);
        }
    }

    private void createCriteria(String albumName, String sales, String rating, String downloads) {
        int albumId = albumController.findByName(albumName).getId();
        int albumSales = Integer.parseInt(sales);
        float albumRating = Float.parseFloat(rating);
        int albumDownloads = Integer.parseInt(downloads);

        Criteria criteria = new Criteria();
        criteria.setAlbumId(albumId);
        criteria.setAlbumSales(albumSales);
        criteria.setRating(albumRating);
        criteria.setDownloads(albumDownloads);

        criteriaController.save(criteria);
    }

    private void createArtist(String artistName) {
        Artist artist = new Artist();
        artist.setName(artistName);

        artistController.save(artist);
    }

    private void createAlbum(String albumName, String artistName) {
        Album album = new Album();
        album.setName(albumName);

        Artist artist = artistController.findByName(artistName);
        if (artist == null) {
            createArtist(artistName);
            artist = artistController.findByName(artistName);
        }

        album.setArtistId(artist.getId());
        albumController.save(album);
    }

    private void listAlbums(String artistName) {
        Artist artist = artistController.findByName(artistName);

        if (artist == null) {
            System.out.println("No artist found");
        } else {
            int id = artist.getId();
            List <Album> albums = albumController.findByArtistId(id);
            for (Album album : albums) {
                System.out.println(album);
            }

        }
    }
}