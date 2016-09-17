package weather.dbinterfaces.mysql;

import java.sql.*;
import java.util.Date;

public class sqlGet {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select date, wind_speed, wind_direction from table1";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(
                    JdbcProperties.getUrl(),
                    JdbcProperties.getUser(),
                    JdbcProperties.getPassword()
            );

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Date date = rs.getDate(1);
                Float wind_speed = rs.getFloat(2);
                int wind_direction = rs.getInt(3);
                System.out.println(date + "  " + wind_speed + "  " + wind_direction);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}
