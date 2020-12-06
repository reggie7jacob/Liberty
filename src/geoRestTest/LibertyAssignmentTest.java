package geoRestTest;

import java.io.IOException;
import georest.Messages;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import georest.LibertyAssignmentCore;

public class LibertyAssignmentTest {
	
	public LibertyAssignmentTest() {};

	LibertyAssignmentCore libertyCore;
	
	String regresUrl = Messages.getString("regresURL");

	// test class with test methods here	 
	@BeforeTest
	public void beforeTest() {
		System.out.println("--------Starting Liberty Test ------- \n ");  
		libertyCore = new LibertyAssignmentCore();	  
	}

	@Test
	public void withdrawNegativeAmountTest() {
		
		Assert.assertFalse(libertyCore.Withdraw(-2000));
	}

	
	@Test
	public void withdrawSomeTest() {
		
		Assert.assertTrue(libertyCore.Withdraw(20));
	}
	
	@Test
	public void withdrawTooMuchTest() {
		
		Assert.assertFalse(libertyCore.Withdraw(200000));
	}
	
	
	@Test
	public void getUsersDataTest() {
		String usersData=libertyCore.getDataAsString(regresUrl);
		JsonArray usersDataJson=null;
		try {
			usersDataJson=libertyCore.getUsersData(usersData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new GsonBuilder().setPrettyPrinting().create().
				toJson(new JsonParser().parse(usersDataJson.toString())));
	}
	
	@Test
	public void sendPostTest() {	  

		try {
			Assert.assertEquals(201,libertyCore.sendPost(regresUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendPostWithInputDataTest() {	  
		String payLoad = "{\"data\":[{\"email\": \"vrezhAkopyan@gmail.com\", " +
                "\"first_name\": \"Vrezh2\", " + "\"last_name\": \"Akopyan2\"," + 
				"\"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"}]}";
		try {
			Assert.assertEquals(201,libertyCore.sendPostWithData(regresUrl,payLoad));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void sendPostWithInputGivenAsTest() {	  
		String payLoad = "{\"name\":\"darth vader\","+"\"job\":\"villain\"}";
		try {
			Assert.assertEquals(201,libertyCore.sendPostWithData(regresUrl,payLoad));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
