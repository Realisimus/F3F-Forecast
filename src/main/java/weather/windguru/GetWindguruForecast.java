package weather.windguru;

import weather.WindTable;
import java.io.IOException;

public class GetWindguruForecast {

    public static WindTable get(Places place) throws IOException {
        return WindguruRawParser.parse(GetWindguruRaw.get(place));
    }

}
