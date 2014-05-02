package com.larmen.whoshome;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class NetworkHandler {

	private static final String URL_BASE = "http://www.petterdoesitbetter.com/whoshome/";
	private static final String URL_GET_STATUSES = "get_statuses.php";
	private static final String ATTRIBUTE_MAC = "mac";
	private static final String ATTRIBUTE_RESULT = "result";
	private static final String ATTRIBUTE_PEOPLE = "people";
	private static final String ATTRIBUTE_NICK = "nick";
	private static final String ATTRIBUTE_LAST_MESSAGE = "latestMsg";
	private static final String ATTRIBUTE_IS_HOME = "isHome";
	private static final String RESULT_SUCCESS = "success";

	private static final int AWAY_TIMEOUT_MILLIS = 1000 * 60 * 5;

	private SimpleDateFormat dateFormat;

	public NetworkHandler() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	}

	public void getPeople(String mac) {
		new LoadTask().execute(URL_BASE + URL_GET_STATUSES + "?mac=" + mac);
	}

	private class LoadTask extends AsyncTask<String, Person, String> {

		@Override
		protected String doInBackground(String... params) {
			Log.d("TASK", "do in background");
			StringBuilder result = new StringBuilder();
			String url = params[0];

			HttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = null;
			HttpResponse response = null;
			ArrayList<Person> persons = new ArrayList<Person>();

			try {
				getRequest = new HttpGet(url);
				response = httpClient.execute(getRequest);
				if (response.getStatusLine().getStatusCode() == 200) {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(response.getEntity()
									.getContent()));
					String line;
					while ((line = reader.readLine()) != null) {
						result.append(line);
					}

					JSONObject root = new JSONObject(result.toString());
					JSONArray people = root.getJSONArray(ATTRIBUTE_PEOPLE);

					for (int i = 0; i < people.length(); i++) {
						JSONObject person = people.getJSONObject(i);
						String nick = person.getString(ATTRIBUTE_NICK);
						String latestMsg = person
								.getString(ATTRIBUTE_LAST_MESSAGE);
						int isHome = person.getInt(ATTRIBUTE_IS_HOME);
						
						boolean home = (isHome == 1 && new Date().getTime()
								- dateFormat.parse(latestMsg).getTime() < AWAY_TIMEOUT_MILLIS);
						
						long timeDiff = new Date().getTime()
								- dateFormat.parse(latestMsg).getTime();
						
						//persons.add(new Person(nick, home));
						publishProgress(new Person(nick, home));
						//Log.d("Person", nick + ", " + latestMsg + ", " + home + ", " + timeDiff);
					}

				} else {
					Log.d("task", "is bad");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "result done";
		}

		@Override
		protected void onPostExecute(String result) {
			Log.d("Result", result);
		}

		@Override
		protected void onProgressUpdate(Person... persons) {
			
			Log.d("Person", persons[0].getName() + ", " + persons[0].isHome());
		}

	}
}
