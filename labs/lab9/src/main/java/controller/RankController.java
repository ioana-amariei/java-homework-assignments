package controller;

import config.Database;
import mapper.RankMapper;
import model.Rank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class RankController {
    public List<Rank> findAllByDownloads() throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ARTISTS, ALBUMS, CRITERIA " +
                "WHERE ARTISTS.id = ALBUMS.artist_id" +
                " AND " +
                "CRITERIA.album_id = ALBUMS.id " +
                "ORDER BY CRITERIA.downloads DESC";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        List<Rank> ranks = new LinkedList<>();
        while(resultSet.next()){
            RankMapper rankMapper = new RankMapper();
            ranks.add(rankMapper.mapRow(resultSet, 0));
        }

        return ranks;
    }

    public List<Rank> findAllBySales() throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM ARTISTS, ALBUMS, CRITERIA " +
                "WHERE ARTISTS.id = ALBUMS.artist_id" +
                " AND " +
                "CRITERIA.album_id = ALBUMS.id " +
                "ORDER BY CRITERIA.album_sales DESC";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        List<Rank> ranks = new LinkedList<>();
        while(resultSet.next()){
            RankMapper rankMapper = new RankMapper();
            ranks.add(rankMapper.mapRow(resultSet, 0));
        }

        return ranks;
    }
}
