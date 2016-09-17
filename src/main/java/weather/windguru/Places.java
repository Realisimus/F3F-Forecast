package weather.windguru;

public enum Places {

    ODESSA("http://www.windguru.cz/ru/index.php?sc=9425");

    private String url;

    Places(String url) {
        this.url = url;
    }

    public String getPlaceUrl () {
        return url;
    }

}
