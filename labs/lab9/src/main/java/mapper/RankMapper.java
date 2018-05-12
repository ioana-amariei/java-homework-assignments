package mapper;

import model.Rank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankMapper {
    public Rank mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String artistName = resultSet.getString("ARTISTS.name");
        String albumName = resultSet.getString("ALBUMS.name");
        float rating = resultSet.getFloat("CRITERIA.rating");
        int downloads = resultSet.getInt("CRITERIA.downloads");
        int albumSales = resultSet.getInt("CRITERIA.album_sales");

        return new Rank(albumName, artistName, downloads, rating, albumSales);
    }
}
