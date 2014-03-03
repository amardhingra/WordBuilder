package com.example.wb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;


public class ShortGame extends Activity {
	
	final int UPDATE_WORD = 0;
	final int OPPONENT_LEFT = 1;
	final int NEW_PORT = 2;
	final int PLAYER_TURN = 3;
	final int PLAYER_WIN = 4;
	final int PLAYER_LOSS = 5;
	final int CHALLENGE = 6;
	
	final String IP = "160.39.204.139";
	
	int port = 2000;
	
	int add = 0;
	boolean challenge_mode = false;
	int word_length = 0;
	boolean turn = false;
	
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.short_game);
		
		//initializing the game Buttons
		final Button build = (Button) findViewById(R.id.buildButton);
		final Button challenge = (Button) findViewById(R.id.challengeButton);
		final Button buttonQuit = (Button) findViewById(R.id.buttonQuit);
		
		//initializing the Textviews 
		final TextView topWord = (TextView) findViewById(R.id.topWord);
		final TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
		final TextView centerWord = (TextView) findViewById(R.id.centerWord);
		final TextView bottomWord = (TextView) findViewById(R.id.bottomWord);
		
		//Creating a handler
		final Handler handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg) //Handling the different server comms
			{
				Log.d("b", msg+"");
				if(msg.what == OPPONENT_LEFT)
				{	
					//Opponent leaves
					//Take player to the next screen
					
					gameStatus.setText("Your opponent left");
					Intent quit = new Intent(ShortGame.this,GameOver.class);
					startActivity(quit);
					finish();
					return;
				}
				else if(msg.what == UPDATE_WORD)
				{
					StringTokenizer stk = new StringTokenizer(msg.obj+"");
					if(stk.nextToken().equalsIgnoreCase("WordUpdate:"))
					{
						//Updating centerWord
						String word = stk.nextToken().toString();
						SpannableString word2 = new SpannableString(word);
						word2 = new StringOps().toPurple(word2);
						centerWord.setText(word2, BufferType.SPANNABLE);
						return;
					}
				}
				else if(msg.what == NEW_PORT)
					{
						//getting a new port
						port = (Integer) msg.obj;
					}
				
				else if(msg.what == PLAYER_TURN)
				{	
					//Setting Player turn
					turn = true;
					gameStatus.setText("It's your turn");
				}
				else if(msg.what == PLAYER_WIN)
				{
					//Player wins. Setting bottomWord as centerWord
					turn = true;
					String word = centerWord.getText().toString();
					SpannableString word2 = new SpannableString(word);
					word2.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word2.length(), 0);
					bottomWord.setText(word2, BufferType.SPANNABLE);
					centerWord.setText("");
				}
				else if(msg.what == PLAYER_LOSS)
				{
					//Player loses. Setting topWord as centerWord
					turn = false;
					String word = centerWord.getText().toString();
					SpannableString word2 = new SpannableString(word);
					word2.setSpan(new ForegroundColorSpan(Color.RED), 0, word2.length(), 0);
					topWord.setText(word2, BufferType.SPANNABLE);
					centerWord.setText("");
				}
				else if(msg.what == CHALLENGE)
				{
					//Player gets challenged. Enter challenge mode
					turn = true;
					challenge_mode = true;
					gameStatus.setText("You have been challenged");
					challenge.setText("Admit Defeat");
				}
			}
		};
		
		//initializing letterButtons
		//final letterButton[] letterButtonArray = new letterButton[26];
		//for(char i = 0; i<26;i++)
		
			
		letterButton a = new letterButton("a", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton b = new letterButton("b", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton c = new letterButton("c", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton d = new letterButton("d", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton e = new letterButton("e", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton f = new letterButton("f", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton g = new letterButton("g", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton h = new letterButton("h", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton i = new letterButton("i", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton j = new letterButton("j", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton k = new letterButton("k", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton l = new letterButton("l", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton m = new letterButton("m", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton n = new letterButton("n", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton o = new letterButton("o", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton p = new letterButton("p", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton q = new letterButton("q", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton r = new letterButton("r", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton s = new letterButton("s", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton t = new letterButton("t", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton u = new letterButton("u", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton v = new letterButton("v", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton w = new letterButton("w", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton x = new letterButton("x", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton y = new letterButton("y", (ImageButton) findViewById(R.id.buttonA), centerWord);
		letterButton z = new letterButton("z", (ImageButton) findViewById(R.id.buttonA), centerWord);

		
		//Build button operation
		build.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//Only works if it is the players turn and they have entered a letter
				if(turn && add == 1)
					{
						String word = centerWord.getText()+"";
						new ServCon(IP, port, handler, word.substring(word.length()-1)).execute();
						gameStatus.setText("Opponent's Turn");
						++word_length;
						add = 0;
					}

			}
		});
		
		//Challenge button operation
		challenge.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Sending challenge to server
				if(turn && !challenge_mode)
				{
					new ServCon(IP, port, handler, "CHALLENGED").execute();
				}
				//Giving up when Player has been challenged
				if(turn && challenge_mode)
				{
					new ServCon(IP, port, handler, "GIVEUP").execute();
				}
				
			}
		});
		
		//Quit button operation
		buttonQuit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Telling server player has quit if player hits quit button
				new ServCon(IP, port, handler, "QUIT").execute();
				Intent quit = new Intent(ShortGame.this,GameOver.class);
				startActivity(quit);
				finish();
			}
		});
	
		new ServCon(IP, port, handler, "NA").execute();
		
	}
	
	
	private class letterButton
	{
		String letter;
		ImageButton img;
		TextView centerWord;
		SpannableString wordSpan;
		StringOps s;
		
		public letterButton(String character, ImageButton i, TextView word)
		{
			letter = character;
			img = i;
			centerWord = word;
			s = new StringOps();
			setup();
		}
		
		public void setup()
		{
			img.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (turn){
						
						//Player hasn't already entered a letter
						if (add == 0){
							String word = centerWord.getText().toString();
							String word2 = word + letter;
							SpannableString w3 = new SpannableString(word2);
							w3.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word_length, 0);
							w3.setSpan(new ForegroundColorSpan(Color.BLUE), word_length, w3.length(), 0);
							if (!challenge_mode)
							{
								w3.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, w3.length()-1, 0);
								w3.setSpan(new ForegroundColorSpan(Color.BLUE), w3.length()-1, w3.length(), 0);
								add = 1;
								
							}
							centerWord.setText(wordSpan, BufferType.SPANNABLE);
						}
						
						//Player has already entered a letter
						else if (add == 1) {
							String word = centerWord.getText().toString();
							word = word.substring(0,word.length()-1);
							String word2 = word + letter;
							SpannableString wordSpan = new SpannableString(word2); 
							wordSpan.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, wordSpan.length()-1, 0);
							wordSpan.setSpan(new ForegroundColorSpan(Color.BLUE), wordSpan.length()-1, wordSpan.length(), 0);
							centerWord.setText(wordSpan, BufferType.SPANNABLE);
						}
					}
				}
			});
		}
	}
	
	private class ServCon extends AsyncTask<String, Void, String>
	{
		String ip;
		int port;
		String data;
		Handler h;
		String let;

		@Override
		protected String doInBackground(String... params) {
			try
			{
				Socket s = new Socket(ip, port);
				String inetaddr = s.getInetAddress().toString();
				Log.d("Connected to", inetaddr);
				PrintWriter o = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				if(!let.equalsIgnoreCase("NA"))
					o.println(let);
				if(this.port == 2000)
				{
					Integer port = Integer.parseInt(r.readLine());
					h.sendMessage(h.obtainMessage(2, (Integer) port));
				}
				for(;;)
				{
					String msg = r.readLine();
					if(!msg.equals("test"))
					{
						if(msg.equalsIgnoreCase("Player Turn"))
						{
							h.sendMessage(h.obtainMessage(3, msg));
							return msg;
						}
						StringTokenizer stk = new StringTokenizer(msg);
						Message message = h.obtainMessage(1);
						String code = stk.nextToken();
						
						if(code.equalsIgnoreCase("WordUpdate:"))
							message = h.obtainMessage(0, msg);
						
						else if(code.equalsIgnoreCase("WordWin"))
							message = h.obtainMessage(4);
						
						else if(code.equalsIgnoreCase("WordLoss"))
							message = h.obtainMessage(5);
						else if(code.equalsIgnoreCase("Challenged:"))
							message = h.obtainMessage(6);
						if(message.what == 4 || message.what == 5)
						{
							h.sendMessage(message);
							Log.d("Game Over", "WIN/LOSS");
							return msg;
						}
						h.sendMessage(message);
					}
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			return data;
		}
		
		public ServCon(String iNetAddr, int port, Handler h, String letter)
		{
			ip = iNetAddr;
			this.port = port;
			data = "";
			this.h = h;
			let = letter;
		}
	}
}