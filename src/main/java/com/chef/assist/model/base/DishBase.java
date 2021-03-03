package com.chef.assist.model.base;

/**
 * @author chenhong
 * @create 2021/3/2
 * @desc
 */
public class DishBase {
    String Temperature;

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    String humidity;

}
