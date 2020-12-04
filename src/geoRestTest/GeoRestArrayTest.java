package geoRestTest;

import georest.GeoRestArray;
import georest.Messages;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class GeoRestArrayTest {

	GeoRestArray restApiArrayTests;

	// test class with test methods here	 
	@BeforeTest
	public void beforeTest() {
		System.out.println("--------Starting Liberty Test ------- \n ");  
		restApiArrayTests = new GeoRestArray();	  
	}

	@Test
	public void getUsersDataTest() {
		String usersData=restApiArrayTests.getDataAsString((Messages.getString("httpURL2")));
		System.out.println("-------Users ------- \n "+usersData);  
		JsonArray usersDataJson=null;
		try {
			usersDataJson=restApiArrayTests.getUsersData(usersData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n-------Users json ------- \n "+usersDataJson.toString()); 
	}
	
	@Test
	public void sendPostTest() {	  

		try {
			Assert.assertEquals(201,restApiArrayTests.sendPost(Messages.getString("httpURL2")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendPostWithInputDataTest() {	  
		String payLoad = "{\"data\":[{\"email\": \"vrezhAkopyan@gmail.com\", " +
                "\"first_name\": \"Vrezh2\", " + "\"last_name\": \"Akopyan2\"," + 
				"\"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"}]}";
		try {
			Assert.assertEquals(201,restApiArrayTests.sendPostWithData(Messages.getString("httpURL2"),payLoad));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendPostWithInputDataTest2() {	  
		String payLoad = "{\"page\": \"1\","+ "\"per_page\": \"6\","+"\"total\": \"13\","+"\"total_pages\": \"3\","+"\"data\":[{\"email\": \"vrezhAkopyan@gmail.com\", " +
                "\"first_name\": \"Vrezh2\", " + "\"last_name\": \"Akopyan2\"," + 
				"\"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"}]}";
		try {
			Assert.assertEquals(201,restApiArrayTests.sendPostWithData(Messages.getString("httpURL2"),payLoad));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void sendPostWithInputGivenAsTest() {	  
		String payLoad = "{\"name\":\"darth vader\","+"\"job\":\"villain\"}";
		try {
			Assert.assertEquals(201,restApiArrayTests.sendPostWithData(Messages.getString("httpURL2"),payLoad));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
