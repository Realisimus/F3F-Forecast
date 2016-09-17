package weather.windguru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class GetWindguruRaw {

    static String get(Places place) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        URL url = new URL(place.getPlaceUrl());
        URLConnection uc = url.openConnection();

        br = new BufferedReader(
                new InputStreamReader(
                        uc.getInputStream()));

        try {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

}
