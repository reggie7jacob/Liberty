package georest;
/*
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeoRestMap {

	public GeoRestMap() {}
	Boolean showInfo=false;


	public int getHttpCode(String thisUrl, String httpRequestMethod){

		try
		{
			URL url = new URL(thisUrl);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(httpRequestMethod);
			connection.connect();

			int code = connection.getResponseCode();  
			System.out.println("HTTP response status code: "+code+"\n");
			return code;
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return -1;
		}
	}


	/**
	 *
	 * @return string of states info
	 * NOTE: there are invalid names such as dates instead of names etc.
	 * I decided NOT to strip the data, just verify and returned data with message
	 *
	 */

	public String getGeoData(String httpRequesType) {

		StringBuilder result;
		String returnResult=null;
		HttpGet request = new HttpGet(httpRequesType);
		HttpClient client = HttpClientBuilder.create().build();

		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			result = new StringBuilder();
			String line = "";

			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			returnResult=result.toString();
			return returnResult;

		} catch (IOException e) {
			System.out.println("ERROR: Unable to process the request. Please check the URL \n");
			e.printStackTrace();
		}
		finally {
			HttpClientUtils.closeQuietly(client);
		}
		return returnResult;
	}


	/**
	 * @param statesInfo array of state jasons
	 * @return Hash map representation of these objects, with key tied to abbr
	 */

	public HashMap<String, JsonObject> mapStatesViaAbbr(JsonArray statesInfo){

		JsonObject currentJsonObj=null;
		HashMap<String, JsonObject> stateMap = new HashMap<>();

		for (int i = 0; i < statesInfo.size(); i++) {
			String abbr="";

			currentJsonObj=statesInfo.get(i).getAsJsonObject();

			if(currentJsonObj.has("abbr")) {
				abbr =currentJsonObj.get("abbr").getAsString();
			}
			else {
				abbr="NULL";
			}
			if(showInfo) {
				System.out.println("\n in getGeoObjMap >> The state abbr is: " +abbr+" \n acurrentJsonObj is : "+currentJsonObj.toString()+"\n");
			}
			stateMap.put(abbr, currentJsonObj);
		}
		return stateMap;
	}


	/**
	 *
	 * @param statesInfo
	 * @return Hash map representation of these objects, with key tied to name of states
	 */
	public HashMap<String, JsonObject> mapStatesViaName(JsonArray statesInfo){

		JsonObject currentJsonObj=null;
		HashMap<String, JsonObject> stateMap = new HashMap<>();

		for (int i = 0; i < statesInfo.size(); i++) {
			String name="";

			currentJsonObj=statesInfo.get(i).getAsJsonObject();

			if(currentJsonObj.has("name")) {
				name =currentJsonObj.get("name").getAsString();
			}
			else {
				name="NULL";
			}
			if(showInfo) {
				System.out.println("\n in getGeoObjMap >> The state name is: " +name+" \n acurrentJsonObj is : "+currentJsonObj.toString()+"\n");
			}
			stateMap.put(name, currentJsonObj);
		}
		return stateMap;
	}
	/**
	 *
	 * @param stateName - string to check for the key
	 * @param stateObj - object per key (state name)
	 * @return if key present returns true
	 */
	public boolean isStateObject(String stateName,HashMap<String, JsonObject> stateObj){

		Boolean  isJsonObj=false;

		if (stateObj.containsKey(stateName)) {

			isJsonObj=true;
			if(showInfo) {
				System.out.println("\n In isStateObject-- Does this object exist?  " +isJsonObj.toString()+"\n");
			}
		}
		return isJsonObj;
	}
	/**
	 *
	 * @param stateName - string to check for the key
	 * @param stateObj - object per key (state name)
	 * @return - single json for the state found, otherwise returns null
	 */
	public JsonObject getStateObject(String stateName,HashMap<String, JsonObject> stateObj){

		if (stateObj.containsKey(stateName)) {

			if(showInfo) {
				System.out.println("\n in getStateObject ... CurrentJsonObj is: " +stateObj.toString()+"\n");
			}
			return stateObj.get(stateName);
		}
		else {
			System.out.println("\n Error: In getStateObject ... No such stateName exists!!");
			return null;
		}
	}

	/**
	 * @param parentElement
	 * @param stateName state name or abbreviation /Note abbreviation length is =2;
	 * @return representation of the array of state jsons
	 * @throws IOException
	 */

	public JsonArray getStatesInfo(String parentElement) throws IOException{

		com.google.gson.JsonObject jsonObject;
		boolean isThisJsonArray;
		JsonArray resultJsonArray=new JsonArray();
		JsonElement restResponse=null;
		if(parentElement!=null) {

			try{
				jsonObject = new JsonParser().parse(parentElement).getAsJsonObject();
				if(jsonObject.has("RestResponse"))
				{
					restResponse=jsonObject.getAsJsonObject().get("RestResponse");
					if(restResponse.getAsJsonObject().has("result"))
					{

						try {
							isThisJsonArray =restResponse.getAsJsonObject().get("result").isJsonArray();

							if(isThisJsonArray) {
								resultJsonArray =restResponse.getAsJsonObject().get("result").getAsJsonArray();
								if (showInfo) System.out.println("In getStatesInfo -- isThisJsonArray?  "+isThisJsonArray+"\n"+resultJsonArray.toString()+"\n");
							}
							else
							{
								System.out.println("Error: Not a json array!!");
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else System.out.println("Error: No result element was found in json !! ");
				}
				else System.out.println("Error: This is not a valid response object ");
			}
			catch(Exception e) {
				System.out.println("Error: Unable to get the result set");
				e.printStackTrace();
			}
			return resultJsonArray;
		}
		else return null;
	}

	/**
	 *
	 * @param toExamine - strings to check
	 * @return if any exists then return true
	 */
	public boolean hasIllegalCharacters(String toExamine) {
		String[] arr = toExamine.split(Messages.getString("illegalChars"), 2);
		return arr.length > 1;

	}

	public boolean findStateInfo(String stateNameGiven, String urlType) {

		JsonArray result;
		String resultSet="";
		if(hasIllegalCharacters(stateNameGiven)){
			return false;
		}
		try {
			resultSet = getGeoData(urlType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (resultSet!=null) {

			HashMap<String, JsonObject> mapStatesNames;
			HashMap<String, JsonObject> mapStatesAbbr;
			try {
				result=getStatesInfo(resultSet);
				mapStatesNames = mapStatesViaName(result);
				mapStatesAbbr = mapStatesViaAbbr(result);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}

			if (!result.isJsonNull()) {
				Boolean stateObjExists = false;
				Boolean abbrObjExists = false;

				stateObjExists = isStateObject(stateNameGiven,mapStatesNames);
				abbrObjExists = isStateObject(stateNameGiven.toUpperCase(),mapStatesAbbr);

				if(stateObjExists||abbrObjExists) {
					JsonObject stateObj=null;
					if (stateObjExists) {
						stateObj = getStateObject(stateNameGiven,mapStatesNames);
					}
					else if(abbrObjExists) {
						stateNameGiven=stateNameGiven.toUpperCase();
						stateObj = getStateObject(stateNameGiven,mapStatesAbbr);
					}
					if(stateObj.has("capital")) {
						String capitalCity=stateObj.get("capital").toString().replaceAll("\"", "");

						if(hasIllegalCharacters(capitalCity)) {
							System.out.println("The name of the capital city "+ capitalCity +" seem to be illegal!!\n");
						}
						System.out.println("Capital is: "+capitalCity);
					}
					else {
						System.out.println("No Capital is present for "+ stateNameGiven + "\n");
					}
					if(stateObj.has("largest_city")) {
						String largestCity = stateObj.get("largest_city").toString().replaceAll("\"", "");

						if(hasIllegalCharacters(largestCity)) {
							System.out.println("The name of the largest city " +largestCity+" seem to be illegal !!\n");

						}
						System.out.println("Largest City is: "+largestCity+"\n");
						return true;
					}
					else {
						System.out.println("No Largest City is present for "+stateNameGiven+"\n");
						return true;
					}
				}//END of  state or abbr
				else {
					
					System.out.println("Neither stateObjExists or abbrObjExists");
					return false;
				}
			}//
			else  System.out.println("Error processing json \n");
			return false;
		}
		else  System.out.println("No data received!!!, please check the URL \n");
		return false;
	}
}
