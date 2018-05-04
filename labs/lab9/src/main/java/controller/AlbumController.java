package controller;

import java.sql.*;

public class AlbumController {
    public void create(String name, int artistId,  int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();

        try (PreparedStatement pstmt = connection.prepareStatement("insert into albums (name, artistId, releaseYear) values (?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, artistId);
            pstmt.setInt(2, releaseYear);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();

        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("select id from albums where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    //displays all the albums from the specified artist
    public void list(int id) throws SQLException {
        Connection connection = Database.getConnection();

        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("select name from albums where artist_id='" + id + "'")) {
            if(resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        }
    }
}
