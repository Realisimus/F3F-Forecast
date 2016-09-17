package weather;

import weather.dbinterfaces.DataConnector;
import weather.windguru.GetWindguruForecast;
import weather.windguru.Places;
import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {

        WindTable windTable = GetWindguruForecast.get(Places.ODESSA);
        DataConnector.getDb().save(windTable);
        System.out.println(DataConnector.getDb().get());

    }
}
