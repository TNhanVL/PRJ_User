/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TTNhan
 */
public class User {

    private int ID;
    String user_name;
    String password;
    String full_name;

    public User() {
    }

    public User(String user_name, String password, String full_name) {
        this.user_name = user_name;
        this.password = password;
        this.full_name = full_name;
    }

    public User(int ID, String user_name, String password, String full_name) {
        this.ID = ID;
        this.user_name = user_name;
        this.password = password;
        this.full_name = full_name;
    }

    public int getID() {
        return ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

}
