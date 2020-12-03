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
		System.out.println("--------Starting GeoRestArrayTest ------- \n ");  
		restApiArrayTests = new GeoRestArray();	  
	}


	@Test
	public void getUsersData() {
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
	
	
	//=========================================================================================//
	@Test
	public void IllegalCharTest() {	  

		Assert.assertFalse(restApiArrayTests.findStateInfo("Alab@aMa", Messages.getString("httpURL")));
	}

	@Test
	public void EmptyCharTest() {	  

		Assert.assertFalse(restApiArrayTests.findStateInfo("", Messages.getString("httpURL")));
	}

	@Test
	public void findWAStateInfoAbbreviatedWA() {
		Assert.assertTrue(restApiArrayTests.findStateInfo("WA", Messages.getString("httpURL")));
	}

	@Test
	public void findStateFullAlabama() {
		Assert.assertTrue(restApiArrayTests.findStateInfo("AlabaMa", Messages.getString("httpURL")));
	}

	@Test
	public void testSearchAmericanSamoa() {
		Assert.assertTrue(restApiArrayTests.findStateInfo("AS", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchCA() {
		Assert.assertTrue(restApiArrayTests.findStateInfo("CA", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchNY() {
		Assert.assertTrue(restApiArrayTests.findStateInfo("NY", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchFrance() {
		Assert.assertFalse(restApiArrayTests.findStateInfo("France", Messages.getString("httpSearchURL")));
	}

}
