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
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class ShortGame2 extends Activity {
	
	final int PURPLE = Color.rgb(138,  43,  226);
	
	final int UPDATE_WORD = 0;
	final int OPPONENT_LEFT = 1;
	final int NEW_PORT = 2;
	final int PLAYER_TURN = 3;
	final int PLAYER_WIN = 4;
	final int PLAYER_LOSS = 5;
	final int CHALLENGE = 6;
	final int NEW_GAME = 7;
	
	final String IP = "160.39.204.139";
	
	int port = 2000;
	
	int add = 0;
	boolean challenge_mode = false;
	int word_length = 0;
	boolean turn = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.short_game);
		
		Bundle mode = getIntent().getExtras(); 
		String game_mode = mode.getString("game_mode");
		
		//initializing the game Buttons
		final Button build = (Button) findViewById(R.id.buildButton);
		final Button challenge = (Button) findViewById(R.id.challengeButton);
		final Button quit = (Button) findViewById(R.id.buttonQuit);
		
		//initializing the Textviews 
		final TextView topWord = (TextView) findViewById(R.id.topWord);
		final TextView centerWord = (TextView) findViewById(R.id.centerWord);
		final TextView bottomWord = (TextView) findViewById(R.id.bottomWord);
		final TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
		final TextView opponentName = (TextView) findViewById(R.id.opponentName);
		
		//initializing letterButtons
		final ImageButton backspace = (ImageButton) findViewById(R.id.buttonBackspace);
		final LetterButton a = new LetterButton("a", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton b = new LetterButton("b", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton c = new LetterButton("c", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton d = new LetterButton("d", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton e = new LetterButton("e", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton f = new LetterButton("f", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton g = new LetterButton("g", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton h = new LetterButton("h", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton i = new LetterButton("i", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton j = new LetterButton("j", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton k = new LetterButton("k", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton l = new LetterButton("l", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton m = new LetterButton("m", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton n = new LetterButton("n", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton o = new LetterButton("o", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton p = new LetterButton("p", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton q = new LetterButton("q", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton r = new LetterButton("r", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton s = new LetterButton("s", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton t = new LetterButton("t", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton u = new LetterButton("u", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton v = new LetterButton("v", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton w = new LetterButton("w", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton x = new LetterButton("x", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton y = new LetterButton("y", (ImageButton) findViewById(R.id.buttonA), centerWord);
		final LetterButton z = new LetterButton("z", (ImageButton) findViewById(R.id.buttonA), centerWord);
		
		//Creating a handler
		final H handler = new H()
		{
			@Override
			public void handleMessage(Message msg) //Handling the different server comms
			{
				if(msg.what == OPPONENT_LEFT)
				{	
					//Opponent leaves
					//Take player to the next screen
					
					gameStatus.setText("Your opponent left");
					Intent quit = new Intent(ShortGame2.this,GameOver.class);
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
						updateWord(stk.nextToken(), centerWord, PURPLE);
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
					if (bottomWord.getText().length()==0)
					{
						bottomWord.setText(word2, BufferType.SPANNABLE);
						centerWord.setText("");
					}
				
				}
				else if(msg.what == PLAYER_LOSS)
				{
					//Player loses. Setting topWord as centerWord
					turn = false;
					String word = centerWord.getText().toString();
					SpannableString word2 = new SpannableString(word);
					word2.setSpan(new ForegroundColorSpan(Color.RED), 0, word2.length(), 0);
					if (topWord.getText().length()==0)
					{
						topWord.setText(word2, BufferType.SPANNABLE);
						centerWord.setText("");
					}
				}
				else if(msg.what == CHALLENGE)
				{
					//Player gets challenged. Enter challenge mode
					turn = true;
					challenge_mode = true;
					gameStatus.setText("You have been challenged");
					challenge.setText("Admit Defeat");
					backspace.setVisibility(View.VISIBLE);
				}
				else if(msg.what == NEW_GAME)
				{
					a.setVisible(true);
					b.setVisible(true);
					c.setVisible(true);
					d.setVisible(true);
					e.setVisible(true);
					f.setVisible(true);
					g.setVisible(true);
					h.setVisible(true);
					i.setVisible(true);
					j.setVisible(true);
					k.setVisible(true);
					l.setVisible(true);
					m.setVisible(true);
					n.setVisible(true);
					o.setVisible(true);
					p.setVisible(true);
					q.setVisible(true);
					r.setVisible(true);
					s.setVisible(true);
					t.setVisible(true);
					u.setVisible(true);
					v.setVisible(true);
					w.setVisible(true);
					x.setVisible(true);
					y.setVisible(true);
					z.setVisible(true);
					build.setVisibility(View.VISIBLE);
					challenge.setVisibility(View.VISIBLE);
					quit.setVisibility(View.VISIBLE);
					topWord.setVisibility(View.VISIBLE);
					centerWord.setVisibility(View.VISIBLE);
					bottomWord.setVisibility(View.VISIBLE);
					gameStatus.setVisibility(View.VISIBLE);
					opponentName.setVisibility(View.VISIBLE);
				}
			}
		};

		backspace.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (challenge_mode)
				{
					String word = centerWord.getText()+"";
					if(word.length()>word_length)
					{
						word = word.substring(word.length()-1);
						SpannableString wordSpan = new SpannableString(word);
						wordSpan.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word_length, 0);
						wordSpan.setSpan(new ForegroundColorSpan(Color.BLUE), word_length, word.length(), 0);
						centerWord.setText(wordSpan);
					}
				}
			}
		});
		
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
		quit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Telling server player has quit if player hits quit button
				new ServCon(IP, port, handler, "QUIT").execute();
				Intent quit = new Intent(ShortGame2.this,GameOver.class);
				startActivity(quit);
				finish();
			}
		});
		SharedPreferences prefs = getSharedPreferences("com.example.wb", 0);
		String username = prefs.getString("username", "xyz");
		new ServCon(IP, port, handler, username, game_mode).execute();
	}
	
	
	private class LetterButton
	{
		String letter;
		ImageButton img;
		TextView centerWord;
		
		public LetterButton(String character, ImageButton i, TextView word)
		{
			letter = character;
			img = i;
			centerWord = word;
			setup();
		}
		
		public void setVisible(boolean visible)
		{
			if(visible)
			 img.setVisibility(View.VISIBLE);
			else img.setVisibility(View.INVISIBLE);
		}
		
		public void setup()
		{
			img.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (turn){
					
						if (add == 0){
							String word = centerWord.getText().toString();
							String word2 = word + letter;
							SpannableString word3 = new SpannableString(word2);
							word3.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word_length, 0);
							word3.setSpan(new ForegroundColorSpan(Color.BLUE), word_length, word3.length(), 0);
							if (!challenge_mode){
								add = 1;
								word3.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word3.length()-1, 0);
								word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
								}
							centerWord.setText(word3, BufferType.SPANNABLE);
						}
						else if (add == 1) {
							String word = centerWord.getText().toString();
							word = word.substring(0,word.length()-1);
							String word2 = word + letter;
							SpannableString word3 = new SpannableString(word2); 
							word3.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word3.length()-1, 0);
							word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
							centerWord.setText(word3, BufferType.SPANNABLE);
						}
					}
				}
			});
		}
	}

	public static void updateWord(String newWord, TextView tv, int color)
	{
		SpannableString w = new SpannableString(newWord);
		w.setSpan(new ForegroundColorSpan(color), 0, newWord.length(), 0);
		tv.setText(w);
	}
	
	
	private class ServCon extends AsyncTask<String, Void, String>
	{
		String ip;
		int port;
		String data;
		Handler h;
		String let;
		String name;
		String gameMode;

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
		public ServCon(String iNetAddr, int port, Handler h, String username, String gameType)
		{
			ip = iNetAddr;
			this.port = port;
			data = "";
			this.h = h;
			name = username;
			gameMode = gameType;	
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
	
	private static class H extends Handler
	{
		public H()
		{
			super();
		}
	}
}