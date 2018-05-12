package mapper;

import model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistMapper {
    public Artist mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String country = resultSet.getString("country");

        return new Artist(id, name, country);
    }
}
