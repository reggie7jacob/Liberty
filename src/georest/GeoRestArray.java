package georest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GeoRestArray {

	public GeoRestArray() {
	}


	/**
	 * @param endPointUrl end point to hit
	 * @return string of user data
	 */
	public String getDataAsString(String endPointUrl) {

		StringBuilder result = new StringBuilder();
		BufferedReader rd;
		CloseableHttpClient client = null;

		try {
			HttpGet request = new HttpGet(endPointUrl);
			client = HttpClientBuilder.create().build();
			CloseableHttpResponse response = client.execute(request);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println("\nPrinting headers: " +headers+"\n");
			String line = "";

			while ((line = rd.readLine()) != null) {
				result.append(line);

			}
			rd.close();
			return result.toString();

		} catch (IOException e) {
			System.out.println(Messages.getString("CheckURLError"));
			e.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(client);

		}
		return result.toString();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public JsonArray getUsersData(String parentElement) throws IOException {

		com.google.gson.JsonObject jsonObject;
		JsonElement userData = null;
		if (parentElement != null) {

			try {

				jsonObject = new JsonParser().parse(parentElement).getAsJsonObject();
				if (jsonObject.has("data")) {
					userData = jsonObject.getAsJsonObject().get("data");

					try {
						return userData.getAsJsonArray();

					} catch (Exception e) {
						System.out.println("Error: Not a json array!!");
						e.printStackTrace();
						return null;
					}
				} else
					System.out.println("Error: Did not find expected element ");
				return null;
			} catch (Exception e) {
				System.out.println("Unable to get the users data set");
				e.printStackTrace();
				return null;
			}
		} 
		return null;
	}

	/***
	 * 
	 * @param resp
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer s = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			s.append(line);
		}
		rd.close();
		JSONObject objToReturn = new JSONObject(s.toString());
		return objToReturn;
	}

	/**
	 * @param parentElement part of json
	 * @param stateName
	 *  state name or abbreviation /Note abbreviation length is =2;
	 * @return array of the city objects
	 * @throws IOException
	 */

	public JsonArray getStatesInfo(String parentElement) throws IOException {

		com.google.gson.JsonObject jsonObject;
		boolean isThisJsonArray;
		JsonArray resultJsonArray = new JsonArray();
		JsonElement restResponse = null;
		if (parentElement != null) {

			try {

				jsonObject = new JsonParser().parse(parentElement).getAsJsonObject();
				if (jsonObject.has("RestResponse")) {
					restResponse = jsonObject.getAsJsonObject().get("RestResponse");
					if (restResponse.getAsJsonObject().has("result")) {

						try {
							isThisJsonArray = restResponse.getAsJsonObject().get("result").isJsonArray();
							if (isThisJsonArray) {
								resultJsonArray = restResponse.getAsJsonObject().get("result").getAsJsonArray();
							} else {
								System.out.println("Error: Not a json array!!");
								return null;
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else
						System.out.println("Error: No result element was found in json !! ");
				} else
					System.out.println("Error: This is not a valid response object ");
			} catch (Exception e) {
				System.out.println("Unable to get the result set");
				e.printStackTrace();
			}
			return resultJsonArray;
		} else
			return null;
	}

	/**
	 *
	 * @param statesInfo
	 *            - JasonArray that contains state entries/objects
	 * @param state
	 *            - State name or abbreviation. NOTE: since it is a limited set, no
	 *            need to check for a datatype
	 * @return names of largest city and state capital
	 */
	public String getCityPairInfo(JsonArray statesInfo, String state) {

		String currentStateName = "";
		String currentStateAbbr = "";
		String largestCity = " NULL ";
		String capitalCity = " NULL ";
		String cityPair = null;
		JsonElement singleState = null;

		if (!state.isEmpty()) {
			for (int i = 0; i < statesInfo.size(); i++) {
				currentStateName = statesInfo.get(i).getAsJsonObject().get("name").toString();
				currentStateAbbr = statesInfo.get(i).getAsJsonObject().get("abbr").toString();

				if (currentStateName.replaceAll("\"", "").equalsIgnoreCase(state)
						|| currentStateAbbr.replaceAll("\"", "").equalsIgnoreCase(state)) {
					singleState = statesInfo.get(i);
					System.out.println("Current State name " + currentStateName + "  Current state abbreviation "
							+ currentStateAbbr);

					if (singleState.getAsJsonObject().has("largest_city")) {
						largestCity = statesInfo.get(i).getAsJsonObject().get("largest_city").toString()
								.replaceAll("\"", "");
						if (hasIllegalCharacters(largestCity)) {
							System.out.println("The name of the largest city seem to be illegal");
						}
					} else {
						largestCity = " NA";
					}

					if (singleState.getAsJsonObject().has("capital")) {
						capitalCity = statesInfo.get(i).getAsJsonObject().get("capital").toString().replaceAll("\"",
								"");
						if (hasIllegalCharacters(capitalCity)) {
							System.out.println("Please note: The name of the capital city seem to be illegal!!");
						}
					} else {
						capitalCity = " NA";
					}
					cityPair = "Largest City: " + largestCity + "\nThe capital:  " + capitalCity;
				}
			}
			return cityPair;
		} else {
			return "";
		}
	}

	public boolean hasIllegalCharacters(String toExamine) {

		String[] arr = toExamine.split(Messages.getString("illegalChars"), 2);
		return arr.length > 1;
	}

	public boolean findStateInfo(String stateNameGiven, String urlType) {
		JsonArray result = null;
		String resultSet = "";
		String foundCityPair = "";
		if(hasIllegalCharacters(stateNameGiven)){
			return false;
		}
		try {
			resultSet = getDataAsString(urlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (resultSet != null) {
			try {
				result = getStatesInfo(resultSet);				
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			if (!result.isJsonNull()) {				
				if (stateNameGiven.length() > 1) {

					foundCityPair = getCityPairInfo(result, stateNameGiven);

					if (foundCityPair != null) {
						System.out.println("The city pair for " + stateNameGiven + "  :\n" + foundCityPair + "\n");
						//Assert.assertTrue(foundCityPair != null);
						return true;
					} else {
						System.out.println(Messages.getString("InvalidAbbrOrName"));
					}
				} else {
					System.out.println(Messages.getString("IllegalCharchError"));
					return false;
				}
				System.out.println(Messages.getString("InvalidAbbrOrName"));
				return false;
			}
		} else
			System.out.println("Error processing json \n");
		return false;
	} 
}
