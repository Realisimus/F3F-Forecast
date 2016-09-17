package weather.windguru;

import weather.WindProperties;

import java.io.IOException;
import java.util.ArrayList;

public class GetWindguruForecast {

    public static ArrayList<WindProperties> get(Places place) throws IOException {
        return WindguruRawParser.parse(place);
    }

}
