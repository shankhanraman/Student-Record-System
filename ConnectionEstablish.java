/*
* Import the java SQL package
* Load the MySQL Driver
* Register the Driver
* Establish Connection
* create Statement to execute the querries
* Create the ResultSet Obj to store the query result.
 */

import java.sql.*;

public class ConnectionEstablish {
    private String url, username, password;
    public Connection connection;
    public Statement statement;

    ConnectionEstablish() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        url = "jdbc:mysql://localhost:3306/Java_EL";
        username = ""; // put your username here
        password = ""; // put you password here

        connection = DriverManager.getConnection(url, username, password); // Connection Established
        statement = connection.createStatement(); // Statement Created
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT"); // resultSet to store the returned tables
    }
//    public static void main(String[] args) throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
//        // Registered the Driver.
//        // This throws a  java.lang.ClassNotFoundException.
//        // Handled by `throws Exception` at main function.
//
//
//        String url = "jdbc:mysql://localhost:3306/Java_EL";
//        String username = "root";
//        String password = "HackJack404";
//
//        Connection connection = DriverManager.getConnection(url, username, password); // Connection Established
//        Statement statement = connection.createStatement(); // Statement Created
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT"); // resultSet to store the returned tables
//    }
}
