package de.testen;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class Spielwiese {

	@Test
	public void test() throws JSONException {
		long unix_utc = 1496242800;
		String expected = "2017-05-31 15:00:00";
		
		Date date = new Date(new Long(unix_utc)* 1000);
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    System.out.println("date: " + simpleDateFormat.format(date));
	}

}
