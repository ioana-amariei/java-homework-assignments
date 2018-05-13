package mapper;

import model.Criteria;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriteriaMapper {
    public Criteria mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int albumId = resultSet.getInt("album_id");
        int albumSales = resultSet.getInt("album_sales");
        float rating = resultSet.getFloat("rating");
        int downloads = resultSet.getInt("downloads");

        return new Criteria(id, albumId, albumSales, rating, downloads);
    }
}
