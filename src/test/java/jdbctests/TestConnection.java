package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        String dbUrl="jdbc:oracle:thin:@50.17.50.178:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT*FROM regions");

        //next is used to move the pointer to first row in the table
        resultSet.next();

        //getting information with column name
        System.out.println(resultSet.getString("region_name"));

        //getting information with column index(starts 1)
        System.out.println(resultSet.getString(2));





        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }
}