package weather.dbinterfaces;

import weather.dbinterfaces.mysql.sqlConnector;

public class DataConnector {

    private static DataObject db;

    public static synchronized DataObject getDb() {
        if (db == null)
            db = new sqlConnector();
        return db;
    }

}
