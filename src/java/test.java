
import Model.User;
import jakarta.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TTNhan
 */
public class test extends HttpServlet {

    public static void main(String[] args) throws SQLException {
//        Connection conn;
//        PreparedStatement statement;
//        conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
//        statement = conn.prepareStatement("insert into user(user_name, password, full_name) values('ttnhan', '123', 'Tran Thanh Nhan')");
//        statement.execute();

        Connection conn = null;
        PreparedStatement statement = null;
        conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
    }
}
