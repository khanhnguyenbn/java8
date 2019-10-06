package vn.topica.itlab4.db;

import java.sql.*;

public class DBConnection {
    /*
     * Default url, user name, password of DB
     */
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String URL = "jdbc:mysql://localhost:3306/school1";

    /*
     * get Connection
     *
     * @param url the url of DB
     * @param name user name of DB
     * @param password the password of user name
     * @return connection
     */
    public static Connection getConnection(String url, String name, String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }


    // close connection
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {

        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
