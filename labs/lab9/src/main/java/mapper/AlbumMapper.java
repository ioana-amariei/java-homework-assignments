package mapper;

import model.Album;
import model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumMapper {
    public Album mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int artistId = resultSet.getInt("artist_id");
        int releaseYear = resultSet.getInt("release_year");

        return new Album(id, name, artistId, releaseYear);
    }
}
