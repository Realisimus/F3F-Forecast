package weather.dbinterfaces.mysql;

import weather.WindProperties;
import weather.WindTable;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class sqlGet {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static WindTable windTable = new WindTable();

    static WindTable get() {
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
                Date date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(1));
                Float wind_speed = rs.getFloat(2);
                int wind_direction = rs.getInt(3);
                windTable.add(new WindProperties(date, wind_speed, wind_direction, null));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

        return windTable;
    }

}
