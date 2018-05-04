package controller;

import java.sql.*;

public class ArtistController {
    public void create(String name, String country) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "INSERT INTO ARTISTS (name, country) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, country);
        preparedStatement.execute();
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT id FROM ARTISTS WHERE name='" + name + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        return resultSet.next() ? resultSet.getInt(1) : null;
    }
}