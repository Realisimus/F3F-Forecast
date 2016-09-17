package weather.libs;

public class Round {

    public static float round(float number, int scale) {
        int pow = (int) Math.pow(10, scale);
        float tmp = number * pow;
        return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }

}
