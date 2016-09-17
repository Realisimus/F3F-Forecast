package weather.dbinterfaces.mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class JdbcProperties {

    private static JdbcProperties instance;

    private String url;
    private String user;
    private String password;

    private JdbcProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/JDBC.properties");
            property.load(fis);
            this.url = property.getProperty("db.host");
            this.user = property.getProperty("db.login");
            this.password = property.getProperty("db.password");
        } catch (IOException e) {
            System.err.println("ERROR, file not found");
        }
    }

    static String getUrl() {
        if (instance == null) {
            instance = new JdbcProperties();
        }
        return instance.url;
    }

    static String getUser() {
        if (instance == null) {
            instance = new JdbcProperties();
        }
        return instance.user;
    }

    static String getPassword() {
        if (instance == null) {
            instance = new JdbcProperties();
        }
        return instance.password;
    }

}
