package com.example.wb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Friends extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_list);
		new ServCon("google.com 80").execute();
	}
	
	private class ServCon extends AsyncTask<String, Void, String>
	{
		String ip;
		int port;
		String data;

		@Override
		protected String doInBackground(String... params) {
			try {
				Socket s = new Socket(ip, port);
				String inetaddr = s.getInetAddress().toString();
				Log.d("Connected to", inetaddr);
				PrintWriter o = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msg = "GET / HTTP/1.1\n\n";
				o.write(msg);
				o.flush();
				String ans = r.readLine();
				Log.d("ans", ans);
				//aLog.d("done", ans);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		
		public ServCon(String s)
		{
			StringTokenizer st = new StringTokenizer(s);
			ip = st.nextToken();
			port = Integer.parseInt(st.nextToken());
			data = "";
		}
	}
}