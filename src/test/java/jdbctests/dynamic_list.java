package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamic_list {


    String dbUrl = "jdbc:oracle:thin:@52.23.157.19:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
    public void test1() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum<6");

        //in order to get colum names we need resultsetmetadata
        ResultSetMetaData rsmd=resultSet.getMetaData();

        //list of maps to keep all information
        List<Map<String,Object>> queryData=new ArrayList<>();

        //number of columns
        int colCount=rsmd.getColumnCount();

        //loop through each row
        while (resultSet.next()){

            Map<String,Object> row = new HashMap<>();

            //same code to fill dynamically
            for (int i = 1; i <=colCount ; i++) {

                row.put(rsmd.getColumnName(i), resultSet.getObject(i));

            }

            queryData.add(row);
        }


        //print ready map row to the list
        for (Map<String,Object> row : queryData){

            System.out.println(row.toString());
        }


        resultSet.close();
        statement.close();
        connection.close();

    }

}