package com.example.demo.servise;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class CurrencyService {
    public String getUSD(String bynPrice){
        try {
            URL url = new URL("https://www.nbrb.by/api/exrates/rates/usd?parammode=2");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String data = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(data);
            String cur = jsonObject.get("Cur_OfficialRate").toString();

            double course = Double.parseDouble(cur);
            double price = Double.parseDouble(bynPrice);

            return  String.valueOf((int)(price/course));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getEUR(String bynPrice){
        try {
            URL url = new URL("https://www.nbrb.by/api/exrates/rates/eur?parammode=2");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String data = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(data);
            String cur = jsonObject.get("Cur_OfficialRate").toString();

            double course = Double.parseDouble(cur);
            double price = Double.parseDouble(bynPrice);

            return  String.valueOf((int)(price/course));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
