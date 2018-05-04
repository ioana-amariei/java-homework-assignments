package controller;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class AlbumController {
    public void create(String name, int artistId, int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "INSERT INTO ALBUMS (name, artist_id, release_year) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, artistId);
        preparedStatement.setInt(3, releaseYear);
        preparedStatement.execute();
    }

    //displays all the albums from the specified artist
    public void list(int id) throws SQLException {
        Connection connection = Database.getConnection();

        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM ALBUMS WHERE artist_id='" + id + "'")) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        }
    }
}
