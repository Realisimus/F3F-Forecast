package weather;


import weather.windguru.GetWindguruForecast;
import weather.windguru.Places;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) throws IOException {

        ArrayList<WindProperties> windTable = GetWindguruForecast.get(Places.ODESSA);

    }

}
