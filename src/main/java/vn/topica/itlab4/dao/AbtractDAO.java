package vn.topica.itlab4.dao;

import vn.topica.itlab4.db.DBConnection;
import vn.topica.itlab4.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbtractDAO<T> {

   public List<T> getAll(String tableName, RowMapper<T> rowMapper){
       List<T> result = new ArrayList<>();

       String sql = "SELECT * FROM " + tableName;
       Connection connection = DBConnection.getConnection(DBConnection.URL, DBConnection.USER_NAME, DBConnection.PASSWORD);
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;

       try {
           preparedStatement = connection.prepareStatement(sql);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               result.add(rowMapper.mapRow(resultSet));
           }
           return result;
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       } finally {
           DBConnection.close(resultSet, preparedStatement, connection);
       }
   }

}
