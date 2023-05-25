/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TTNhan
 */
public class DB {

    static Connection conn;
    static PreparedStatement statement;

    private static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
    }

    private static void disconnect() throws SQLException {
        conn.close();
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> dataList = new ArrayList<>();

        try {
            connect();
            statement = conn.prepareStatement("select * from user");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
                dataList.add(user);
            }
            disconnect();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataList;
    }

    public static boolean checkUserExist(String username) {
        boolean found = false;
        try {
            connect();
            statement = conn.prepareStatement("select user_name from user where user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            found = resultSet.next();
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }

    public static void insertUser(User user) {
        try {
            connect();
            statement = conn.prepareStatement("insert into user(user_name, password, full_name) values(?, ?, ?)");
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.execute();
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateUser(User user) {
        try {
            connect();
            statement = conn.prepareStatement("update user set user_name=?, password=?, full_name=? where id=?");
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setString(4, String.valueOf(user.getID()));
            statement.executeUpdate();
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteUser(int ID) {
        try {
            connect();
            statement = conn.prepareStatement("delete from user where id=?");
            statement.setString(1, String.valueOf(ID));
            statement.execute();
            disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
//        try {
//            connect();
//            statement = conn.prepareStatement("select user_name from user where user_name = 'ttNhan'");
//            ResultSet resultSet = statement.executeQuery();
//            boolean found = resultSet.next();
//            disconnect();
//            System.out.println(found);
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(checkUserExist("Nhan"));
    }
}
