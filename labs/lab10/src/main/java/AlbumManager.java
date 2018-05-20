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
                case "update-album":
                    updateAlbum(params[1]); // album name
                    break;
                case "update-artist":
                    updateArtist(params[1]); // artist name
                    break;
                case "delete-artist":
                    deleteArtist(params[1]); // artist name
                    break;
                case "delete-album":
                    deleteAlbum(params[1]); // album name
                    break;
                case "delete-criteria":
                    deleteCriteria(params[1]); // criteria id
                    break;
            }
        }
    }

    private void deleteCriteria(String id) {
        int criteriaId = Integer.parseInt(id);
        Criteria criteriaBeforeDelete = criteriaController.findById(criteriaId);
        System.out.println("Before delete: " + criteriaBeforeDelete);
        criteriaController.delete(criteriaBeforeDelete);
        System.out.println("After delete: " + criteriaController.findById(criteriaId));
    }

    private void deleteAlbum(String name) {
        Album albumBeforeDelete = albumController.findByName(name);
        System.out.println("Before delete: " + albumBeforeDelete);
        albumController.delete(albumBeforeDelete);
        System.out.println("After delete: " + albumController.findByName(name));
    }

    private void deleteArtist(String name) {
        Artist artistBeforeDelete = artistController.findByName(name);
        System.out.println("Before delete: " + artistBeforeDelete);
        artistController.delete(artistBeforeDelete);
        System.out.println("After delete: " + artistController.findByName(name));
    }

    private void updateArtist(String name) {
        Artist artistBeforeUpdate = artistController.findByName(name);
        System.out.println("Before update: " + artistBeforeUpdate);
        artistController.update(artistBeforeUpdate);
        Artist artistAfterUpdate = artistController.findByName(artistBeforeUpdate.getName());
        System.out.println("After update: " + artistAfterUpdate);
    }

    private void updateAlbum(String name) {
        Album albumBeforeUpdate = albumController.findByName(name);
        System.out.println("Before update: " + albumBeforeUpdate);
        albumController.update(albumBeforeUpdate);
        Album albumAfterUpdate = albumController.findByName(albumBeforeUpdate.getName());
        System.out.println("After update: " + albumAfterUpdate);
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