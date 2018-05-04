import controller.AlbumController;
import controller.ArtistController;
import controller.Database;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        try {
            ArtistController artists = new ArtistController();
            AlbumController albums = new AlbumController();

            artists.create("Radiohead", "United Kingdom");
            artists.create("Phoenix", "Romania");
            Database.commit();

            int phoenixId = artists.findByName("Phoenix");
            albums.create("Mugur de fluier", phoenixId,1974);

            int radioheadId = artists.findByName("Radiohead");
            albums.create("OK Computer", radioheadId, 1997);
            albums.create("Kid A", radioheadId, 2000);
            albums.create("In Rainbows", radioheadId, 2007);

            albums.list(radioheadId);
            Database.commit();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
