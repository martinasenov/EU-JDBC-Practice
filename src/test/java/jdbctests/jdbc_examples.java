package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {


    String dbUrl="jdbc:oracle:thin:@50.17.50.178:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";



    @Test
    public void test1() throws SQLException {


        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT*FROM departments");


        // move to first row
        //resultSet.next();

        //System.out.println(resultSet.getString(2));
        //display the "departments" table in 10 - Administration - 200 -  1700 format

        // code for iterating for each row

        while(resultSet.next()){

            System.out.println(
                            resultSet.getInt(1) +
                    " - " + resultSet.getString(2) +
                    " - " + resultSet.getInt(3) +
                    " - " + resultSet.getInt(4));

        }




        //close connection

        resultSet.close();
        statement.close();
        connection.close();




    }

}
