package controller;

import config.Database;
import mapper.CriteriaMapper;
import model.Criteria;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CriteriaController implements EntityController<Criteria, Integer> {
    @Override
    public void save(Criteria criteria) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "INSERT INTO CRITERIA (album_id, album_sales, rating, downloads) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setInt(1, criteria.getAlbumId());
        preparedStatement.setInt(2, criteria.getAlbumSales());
        preparedStatement.setFloat(3, criteria.getRating());
        preparedStatement.setInt(4, criteria.getDownloads());

        preparedStatement.execute();
    }

    @Override
    public Criteria findById(Integer id) throws SQLException {
        Connection connection = Database.getConnection();

        String query = "SELECT id FROM CRITERIA WHERE id='" + id + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        if(resultSet.next()) {
            CriteriaMapper criteriaMapper = new CriteriaMapper();
            return criteriaMapper.mapRow(resultSet, 0);
        }

        return null;
    }

    @Override
    public List<Criteria> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        String query = "SELECT * FROM CRITERIA";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        List<Criteria> criteria = new LinkedList<>();
        while(resultSet.next()){
            CriteriaMapper criteriaMapper = new CriteriaMapper();
            criteria.add(criteriaMapper.mapRow(resultSet, 0));
        }

        return criteria;
    }

    @Override
    public void update(Criteria criteria) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "UPDATE CRITERIA SET album_id = ?, album_sales = ?, rating = ?, downloads = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setInt(1, criteria.getAlbumId());
        preparedStatement.setInt(2, criteria.getAlbumSales());
        preparedStatement.setFloat(3, criteria.getRating());
        preparedStatement.setInt(4, criteria.getDownloads());
        preparedStatement.execute();
    }

    @Override
    public void delete(Criteria criteria) throws SQLException {
        Connection connection = Database.getConnection();

        String statement = "DELETE FROM CRITERIA WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, criteria.getId());

        preparedStatement.execute();
    }
}
