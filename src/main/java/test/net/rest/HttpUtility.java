package test.net.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtility {
	public String getResponse(String url) throws Exception {
		HttpGet request = new HttpGet(url);
		String responseBody;
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		responseBody = EntityUtils.toString(response.getEntity());
		return responseBody;
	}

	public String postResponse(String url) throws Exception {
		HttpPost request = new HttpPost(url);
		String responseBody;
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		responseBody = EntityUtils.toString(response.getEntity());
		if (response.getStatusLine().getStatusCode() > 399) {
			return null;
		}
		return responseBody;
	}

}
