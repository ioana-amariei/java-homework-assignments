package app;

import controller.AlbumController;
import controller.ArtistController;
import entity.Album;
import entity.Artist;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AlbumManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    private static final ArtistController artistController = new ArtistController(emf);
    private static final AlbumController albumController = new AlbumController(emf);

    public static void main(String args[]) {
        new AlbumManager().run();
    }

    public void run() {
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
            }
        }
    }

    private void createArtist(String artistName) {
        Artist artist = new Artist();
        artist.setName(artistName);

        artistController.create(artist);
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
        albumController.create(album);
    }

    private void listAlbums(String artistName) {
      Artist artist = artistController.findByName(artistName);

      if(artist == null) {
          System.out.println("No artist found");
      } else {
        int id = artist.getId();
        List<Album> albums = albumController.findByArtistId(id);
        for(Album album : albums){
            System.out.println(album);
        }

      }
    }
}