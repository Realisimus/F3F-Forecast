package weather.dbinterfaces;

import weather.dbinterfaces.mysql.sql;

public class DataConnector {

    private static DataObject db;

    public static synchronized DataObject getDb() {
        if (db == null)
            db = new sql();
        return db;
    }

}
