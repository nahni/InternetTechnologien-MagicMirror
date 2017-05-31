

package de.uniluebeck.gruppe4.dataservices.weather;

import de.uniluebeck.gruppe4.rest.RestClient;
import de.uniluebeck.gruppe4.utils.JSONParser;

public class WeatherService {

	static final String KEY = "appid=da7c4d55907d8cff81b1e5a02bae88e6";
	static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
	
	public static void main(String[] args) {
		WeatherService service = new WeatherService();
		String actualWeather = service.getActualWeather();
		String forecast = service.getForecast();
		
		double actualTemp = JSONParser.getTemperaturFromJSON(actualWeather);
		System.out.println("actualTemp: " + actualTemp);
		
		double tomorrowTemp = JSONParser.getTomorrowsMaxTemperaturFromJSON(forecast);
		System.out.println("tomorrowTemp: " + tomorrowTemp);
	}
	
	public String getActualWeather() {
		return RestClient.getRequest(BASE_URL + "weather?q=London,uk&" + KEY);
	}
	
	public String getForecast(){
		return RestClient.getRequest(BASE_URL + "forecast?q=London,uk&" + KEY);
	}
	
}

