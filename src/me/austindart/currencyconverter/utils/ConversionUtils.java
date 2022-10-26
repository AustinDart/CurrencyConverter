package me.austindart.currencyconverter.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ConversionUtils
{

    private static final HashMap<String, Double> fromToRateMap = new HashMap<>();

    public static double getConversionRate(String from, String to, String apiKey) throws IOException, ParseException
    {

        // Converting to itself results in a conversion rate of 1
        if(from.equals(to))
        {
            return 1;
        }

        // Cache exchange rates to use fewer API requests
        // This does potentially result in slightly inaccurate exchange rates
        if(fromToRateMap.containsKey(from + "/" + to))
        {
            return fromToRateMap.get(from + "/" + to);
        }

        int amount = 1;
        URL url = new URL("https://api.apilayer.com/currency_data/convert?to=" + to + "&from=" + from + "&amount=" + amount);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("apikey", apiKey);
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
        {
            content.append(inputLine);
        }
        in.close();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(content.toString());

        double result = (Double) jsonObject.get("result");
        fromToRateMap.put(from + "/" + to, result);
        return result;
    }

}
