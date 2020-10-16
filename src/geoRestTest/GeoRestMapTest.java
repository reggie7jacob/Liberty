package geoRestTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import georest.GeoRestMap;
import georest.Messages;
import org.testng.Assert;


public class GeoRestMapTest {

	GeoRestMap geoRestApiTests;

	@BeforeTest
	public void beforeTest() {
		System.out.println("--------Starting Rest API via Map Test ------- \n ");  
		geoRestApiTests =new GeoRestMap();
	}

	@Test
	public void getOkHttpCodeTest() {	  
		Assert.assertEquals(geoRestApiTests.getHttpCode(Messages.getString("httpURL"),"GET"), 200);
	}

	@Test
	public void notAllowdHttpCodeTest() {	  
		Assert.assertEquals(geoRestApiTests.getHttpCode(Messages.getString("httpURL"),"PUT"), 405);
	}

	@Test
	public void invalidURLTest() {	  
		Assert.assertEquals(geoRestApiTests.getHttpCode("http:\\notReallyCorrect.zcom","GET"), -1);
	}

	@Test
	public void IllegalCharTest() {	  
		Assert.assertFalse(geoRestApiTests.findStateInfo("Alab@aMa", Messages.getString("httpURL")));
	}

	@Test
	public void EmptyCharTest() {	  
		Assert.assertFalse(geoRestApiTests.findStateInfo("", Messages.getString("httpURL")));
	}

	@Test
	public void findWAStateInfoAbbreviatedWA() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("WA", Messages.getString("httpURL")));
	}

	@Test
	public void findStateInfoPositiveFullAlabama() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("Alabama", Messages.getString("httpURL")));
	}

	@Test
	public void testSearchAmericanSamoa() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("AS", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchCA() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("CA", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchNY() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("NY", Messages.getString("httpSearchURL")));
	}

	@Test
	public void testSearchNewYork() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("New York", Messages.getString("httpSearchURL")));
	}
	@Test
	public void testSearchGU() {
		Assert.assertTrue(geoRestApiTests.findStateInfo("GU", Messages.getString("httpSearchURL")));
	}

}
