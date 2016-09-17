package weather.windguru;

import weather.WindProperties;

import java.io.IOException;
import java.util.ArrayList;

public class GetWindguruForecast {

    public static ArrayList<WindProperties> get(Places place) throws IOException {

        String windPropertiesRaw = GetWindguruRaw.get(place);
        ArrayList<WindProperties> windProperties = WindguruRawParser.parse(windPropertiesRaw);

        return windProperties;
    }

}
