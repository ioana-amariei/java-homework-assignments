package controller;

import config.Database;
import mapper.ArtistMapper;
import model.Artist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ArtistController implements EntityController <Artist, Integer> {
    @Override
    public void save(Artist artist) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "INSERT INTO ARTISTS (name, country) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, artist.getName());
        preparedStatement.setString(2, artist.getCountry());
        preparedStatement.execute();
    }

    @Override
    public Artist findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT id FROM ARTISTS WHERE id='" + id + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        if(resultSet.next()) {
            ArtistMapper artistMapper = new ArtistMapper();
            return artistMapper.mapRow(resultSet, 0);
        }

        return  null;
    }

    @Override
    public List <Artist> findAll() throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ARTISTS";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        List<Artist> artists = new LinkedList<>();
        while(resultSet.next()){
            ArtistMapper artistMapper = new ArtistMapper();
            artists.add(artistMapper.mapRow(resultSet, 0));
        }

        return artists;
    }

    @Override
    public void update(Artist artist) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "UPDATE ARTISTS SET name = ? , country = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, artist.getName());
        preparedStatement.setString(2, artist.getCountry());
        preparedStatement.setInt(3, artist.getId());
        preparedStatement.execute();
    }

    @Override
    public void delete(Artist artist) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "DELETE FROM ARTISTS WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, artist.getId());

        preparedStatement.execute();
    }


    public Artist findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ARTISTS WHERE name='" + name + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        if(resultSet.next()){
            ArtistMapper artistMapper = new ArtistMapper();
            return artistMapper.mapRow(resultSet, 0);
        }

        return null;
    }
}