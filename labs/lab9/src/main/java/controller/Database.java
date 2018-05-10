package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static final  String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;

    private Database() { }

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
            setCurrentSchema(connection);
        }
        return connection;
    }

    public static Connection createConnection() {
        try {
            Class.forName(DRIVER); // load Oracle driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connection succeeded");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public  static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        try {
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setCurrentSchema(Connection connection) {
        String statement = "ALTER SESSION SET CURRENT_SCHEMA = STUDENT";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}