package FinalProject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Veenadharini
 */
public class ConnectionClass {
    static Connection con;
    //PreparedStatement pst;
    public static void main(String args[]) {
        getConnection();
    }
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");



            con = DriverManager.getConnection("jdbc:mysql://localhost/finalproject","root", "");




            //JOptionPane.showMessageDialog(null, "Success");
           // System.out.println("Success");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error");
    }
        return con;
        
    }
}
