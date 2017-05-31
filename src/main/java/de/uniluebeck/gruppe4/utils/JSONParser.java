package de.uniluebeck.gruppe4.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	/**
	 * Liefert den Temperaturwert aus den Wetterdaten
	 */
	public static double getTemperaturFromJSON(String json){
		JSONObject obj;
		String temp = null;
		try {
			obj = new JSONObject(json);
			temp = obj.getJSONObject("main").getString("temp");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal res = new BigDecimal(temp);
		System.out.println(temp);
		
		return res.doubleValue();
	}
	
	/**
	 * Liefert die Hoechst-Temperatur fuer morgen.
	 * 
	 * @param json
	 * @return
	 */
	public static double getTomorrowsMaxTemperaturFromJSON(String json){
		JSONObject obj;
		double maxTempForTomorrow= 0;
		try {
			obj = new JSONObject(json);
			JSONArray list = obj.getJSONArray("list");
			if(list != null){
				for (int i = 0; i < list.length(); i++){
				    String date_text = list.getJSONObject(i).getString("dt_txt");
				    
				    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				    Date date = null;
					try {
						date = simpleDateFormat.parse(date_text);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    Date tomorrow = DateUtils.addDays(new Date(), 1);
				    
				    if(DateUtils.isSameDay(date, tomorrow)){
				    	//Wir wollen die Maximal-Temperatur ausgeben
				    	//Die erste Temperatur des neuen Tages (waere ja dann quasi 0:00 Uhr macht ja auch keinen Sinn)
				    	JSONObject tomorrowWeather = list.getJSONObject(i);
				    	double temp = getTemperaturFromJSON(tomorrowWeather.toString());
				    	if(temp > maxTempForTomorrow){
				    		maxTempForTomorrow = temp;
				    	}
				    }
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxTempForTomorrow;
	}
}
