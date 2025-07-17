package io.github.codedbygabriel.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandler {
	public static String fetchData(String username) {
		String url = "https://api.github.com/users/"+ username +"/events";
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest,
												HttpResponse.BodyHandlers.ofString());

			System.out.println(httpResponse.statusCode());
			httpClient.close();

			return httpResponse.body();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
