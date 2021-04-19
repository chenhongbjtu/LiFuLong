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
    private Object data1;

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

    public static CaResponse makeResponse2(Object d){
        CaResponse response = new CaResponse();
        response.setData(d);
        return response;
    }

    public  static CaResponse makeResponse3(Object d1, Object d2){
        CaResponse response = new CaResponse();
        response.setData(d1);
        response.setData1(d2);
        return response;

    }
}
