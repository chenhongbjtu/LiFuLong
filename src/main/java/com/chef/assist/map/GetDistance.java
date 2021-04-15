package com.chef.assist.map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chenhong
 * @create 2021/3/3
 * @desc
 */
public class GetDistance {

    public  String getLonLat(String address){
        //返回输入地址address的经纬度信息，格式是经度，纬度
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo?key=1b8e271deb3cfdf7e65ba9779d160fc3&address="+address;
        //高德接口返回的是JSON格式的字符串
        String queryResult = getResponse(queryUrl);

        JSONObject jo = new JSONObject().fromObject(queryResult);
        JSONArray ja = jo.getJSONArray("geocodes");
        return new JSONObject().fromObject(ja.getString(0)).get("location").toString();

    }

    public  Long getDistan(String startLonLat,String endLonLat){
        //返回起始地 与目的地之间的距离，单位米
        Long result = new Long(0);
        Long time = new Long(0);


        String queryUrl = "http://restapi.amap.com/v3/distance?key=1b8e271deb3cfdf7e65ba9779d160fc3&origins="+startLonLat+"&destination="+endLonLat;
        String queryResult = getResponse(queryUrl);
        JSONObject jo = new JSONObject().fromObject(queryResult);
        JSONArray ja = jo.getJSONArray("results");

        result = Long.parseLong(new JSONObject().fromObject(ja.getString(0)).get("distance").toString());
        time = Long.parseLong(new JSONObject().fromObject(ja.getString(0)).get("duration").toString());

        return result;

    }

    public  Long getTime(String startLonLat,String endLonLat){
        //返回起始地 与目的地之间的距离，单位米
        Long time = new Long(0);


        String queryUrl = "http://restapi.amap.com/v3/distance?key=1b8e271deb3cfdf7e65ba9779d160fc3&origins="+startLonLat+"&destination="+endLonLat;
        String queryResult = getResponse(queryUrl);
        JSONObject jo = new JSONObject().fromObject(queryResult);
        JSONArray ja = jo.getJSONArray("results");

        time = Long.parseLong(new JSONObject().fromObject(ja.getString(0)).get("duration").toString());

        return time;

    }



    public static String getResponse(String serverUrl){
        //用JAVA 发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try{
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
