

package de.uniluebeck.gruppe4.dataservices.weather;

import de.uniluebeck.gruppe4.rest.RestClient;

public class WeatherService {

	static final String KEY = "appid=da7c4d55907d8cff81b1e5a02bae88e6";
	static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
	
	public static void main(String[] args) {
		WeatherService service = new WeatherService();
		service.getActualWeather();
	}
	
	public void getActualWeather() {
	
		RestClient client = new RestClient();
		client.getRequest(BASE_URL + "weather?q=London,uk&" + KEY);
		
	}
	
}

