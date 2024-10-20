package main.hotelmanage.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USER = "hotelmanage_user";
    private static final String PASSWORD = "123";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
