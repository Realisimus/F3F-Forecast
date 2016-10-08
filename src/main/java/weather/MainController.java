package weather;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import weather.dbinterfaces.DataConnector;
import weather.windguru.GetWindguruForecast;
import weather.windguru.Places;

import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping(value = "/week.json", method = RequestMethod.GET)
    public @ResponseBody WindTable getWeeklyForecast() {
        return (WindTable) DataConnector.getDb().get();
    }

    @RequestMapping(value = "/getwindguru", method = RequestMethod.GET)
    public void getWindguruForecast() throws IOException {
        WindTable windTable;
        windTable = GetWindguruForecast.get(Places.ODESSA);
        DataConnector.getDb().save(windTable);
    }

}
