

package de.uniluebeck.gruppe4.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {

	public LinkedList<String> getRequest(String url) {
		LinkedList<String> lines = new LinkedList<String>();
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=da7c4d55907d8cff81b1e5a02bae88e6");
			get.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(get);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				lines.add(line.trim());
				System.out.println(line);
			}
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;

	}

}

