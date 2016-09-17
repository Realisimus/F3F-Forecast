package weather.windguru;

import weather.WindProperties;
import weather.libs.Round;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

class WindguruRawParser {

    static ArrayList<WindProperties> parse(Places place) throws IOException {

        String rawData = GetWindguruRaw.get(place);
        ArrayList<WindProperties> windTable = new ArrayList<WindProperties>();

        String startTime = rawData.substring(
                rawData.indexOf("\"initstamp\":") + 12,
                rawData.indexOf("\"initstamp\":") + 22);

        Date date = new Date(new Long(startTime) * 1000);

        String[] windSpeed = rawData.substring(
                rawData.indexOf("\"WINDSPD\":[") + 11,
                rawData.indexOf("],\"WINDDIR\":")
        ).split(",");

        String[] windDirection = rawData.substring(
                rawData.indexOf("\"WINDDIR\":[") + 11,
                rawData.indexOf("],\"SMERN\":[")
        ).split(",");

        for (int i = 0; i < windSpeed.length; i++) {

            windTable.add(
                    new WindProperties(
                            (Date) date.clone(),
                            Round.round((float) (Float.parseFloat(windSpeed[i]) * 0.514444), 1),
                            Integer.parseInt(windDirection[i]),
                            null
                    ));
            date.setTime(date.getTime() + 10800000);
        }

        return windTable;
    }

}
