package controller;

import config.Database;
import mapper.AlbumMapper;
import model.Album;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AlbumController implements EntityController<Album, Integer>{
    @Override
    public void save(Album album) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "INSERT INTO ALBUMS (name, artist_id, release_year) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, album.getName());
        preparedStatement.setInt(2, album.getArtistId());
        preparedStatement.setInt(3, album.getReleaseYear());
        preparedStatement.execute();
    }

    @Override
    public Album findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT id FROM ALBUMS WHERE id='" + id + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        if (resultSet == null) {
            return null;
        }

        AlbumMapper albumMapper = new AlbumMapper();

        return albumMapper.mapRow(resultSet, 0);
    }

    @Override
    public List<Album> findAll() throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ALBUMS";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        List<Album> albums = new LinkedList <>();
        while(resultSet.next()){
            AlbumMapper albumMapper = new AlbumMapper();
            albums.add(albumMapper.mapRow(resultSet, 0));
        }

        return albums;
    }

    @Override
    public void update(Album album) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "UPDATE ARTISTS SET name = ? , artist_id = ?, release_year = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setString(1, album.getName());
        preparedStatement.setInt(2, album.getArtistId());
        preparedStatement.setInt(3, album.getReleaseYear());
        preparedStatement.execute();
    }

    @Override
    public void delete(Album album) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "DELETE FROM ALBUMS WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, album.getId());

        preparedStatement.execute();
    }

    public Album findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ALBUMS WHERE name='" + name + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        if(resultSet.next()){
            AlbumMapper albumMapper = new AlbumMapper();
            return albumMapper.mapRow(resultSet, 0);
        }

        return null;
    }
}
