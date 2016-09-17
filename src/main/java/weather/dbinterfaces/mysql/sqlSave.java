package weather.dbinterfaces.mysql;

import weather.WindProperties;
import weather.WindTable;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class sqlSave {

    private static Connection con;
    private static Statement stmt;

    static void save(WindTable windTable) {

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
            stmt.executeUpdate("DELETE FROM forecast.table1");

            for (WindProperties windProperties:windTable) {

                String query = "INSERT INTO forecast.table1 (date, wind_speed, wind_direction) VALUES ('" +

                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(windProperties.getDate()) + "', " +
                        windProperties.getSpeed() + "," +
                        windProperties.getDirection() + ");";

                stmt.executeUpdate(query);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}
