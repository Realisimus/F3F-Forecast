package weather;

import java.util.Date;

public class WindProperties {

    private Date date;
    private Float speed;
    private Integer direction;
    private Boolean precipitation;

    public WindProperties(Date date, Float speed, Integer direction, Boolean precipitation) {
        this.date = date;
        this.speed = speed;
        this.direction = direction;
        this.precipitation = precipitation;
    }

    public Date getDate() {
        return date;
    }

    public Float getSpeed() {
        return speed;
    }

    public Integer getDirection() {
        return direction;
    }

    public Boolean getPrecipitation () {
        return precipitation;
    }

}
