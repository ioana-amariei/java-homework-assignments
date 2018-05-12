package controller;

import config.Database;
import model.Criteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Criteria findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Criteria> findAll() {
        return null;
    }

    @Override
    public void update(Criteria entity) throws SQLException {

    }

    @Override
    public void delete(Criteria entity) {

    }
}
