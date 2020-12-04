package georest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class LibertyAssignmentCore {

	double m_balance=110.50;
	
	public LibertyAssignmentCore() {
	}

	// should be synchronized but I don't have time for it... sorry
	public boolean Withdraw(double amount) {
		System.out.println("\nBalance before withdrowal is: " +m_balance);
		if(m_balance<=0) return false;
		// if amount is negative it will add money: bug in original question
	    if(m_balance >= amount && amount>0) {
	        m_balance -= amount;
	        System.out.println("\n$ "+amount + "was withdrawn: balance now is: " +m_balance);
	        return true;
	        
	    } else {
	    	// no need to throw exception, just do nothing
	        System.out.println("\nIllegal amount was tried to be withdrawn, balance still is: " +m_balance);	       
	        return false;
	    }
	}


	/**
	 * @param endPointUrl end point to hit //data come from Messages class
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
			
	/*
	 * 
	 */
	public int sendPost(String endPointUrl) throws Exception {
		int statusCode=00;
        String payload = "{\"data\":[{\"email\": \"vrezh@gmail.com\", " +
                "\"first_name\": \"Vrezh\", " + "\"last_name\": \"Akopyan\"}]}";
        
        StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

        CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(endPointUrl);
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        statusCode=response.getStatusLine().getStatusCode();
        System.out.println("Response status code is: " +response.getStatusLine().getStatusCode());
        return  statusCode;
        
    }

	/*
	 * 
	 */
	
	public int sendPostWithData(String endPointUrl, String payLoad) throws Exception {
		int statusCode=00;
        StringEntity entity = new StringEntity(payLoad,ContentType.APPLICATION_JSON);

        CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(endPointUrl);
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        statusCode=response.getStatusLine().getStatusCode();
        System.out.println("Response status code is: " + response.getStatusLine().getStatusCode());
        return  statusCode;
        
    }

	/*
	 * 
	 */
	
	public JsonArray getUsersData(String parentElement) throws IOException {

		JsonObject jsonObject;
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
	

	public boolean hasIllegalCharacters(String toExamine) {

		String[] arr = toExamine.split(Messages.getString("illegalChars"), 2);
		return arr.length > 1;
	}

}
