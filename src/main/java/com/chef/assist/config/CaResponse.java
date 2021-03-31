package com.chef.assist.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaResponse {
    private Object data;
    private Boolean ok;
    private String message;

    private String culocation;
    private String temperature;
    private String humidity;

    public static CaResponse makeResponse(boolean o, String m, Object d){
        CaResponse r = new CaResponse();
        r.setData(d);
        r.setOk(o);
        r.setMessage(m);
        return r;
    }

    public static CaResponse makeResponse1(boolean o,String m, Object d, String location,String temperature,String humidity){
        CaResponse response = new CaResponse();
        response.setOk(o);
        response.setMessage(m);
        response.setCulocation(location);
        response.setData(d);
        response.setHumidity(humidity);
        response.setTemperature(temperature);
        return response;
    }
}
