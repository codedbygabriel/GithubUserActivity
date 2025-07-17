package io.github.codedbygabriel.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHandler {
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public ArrayList<EventData> constructEventList(String user){
		// Tokeniza o tipo que queremos;
		Type type = new TypeToken<ArrayList<EventData>>(){}.getType();

		return gson.fromJson(HttpHandler.fetchData(user), type);
	}
}
