package com.example.wb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		
		final Button shortGame = (Button) findViewById(R.id.ShortestButton);
		final Button longGame = (Button) findViewById(R.id.LongestButton);
		final Button Friends = (Button) findViewById(R.id.Friends);
		final TextView name = (TextView) findViewById(R.id.name);
		SharedPreferences prefs = getSharedPreferences("com.example.wb", 0);
		String username = prefs.getString("username", "xyz");
		name.setText(username);

		shortGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent game = new Intent(MainMenu.this, ShortGame2.class);
				game.putExtra("mode", "short");
				startActivity(game);
			}
		});
		
		longGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent longGameMode = new Intent(MainMenu.this, LongGame.class);
				startActivity(longGameMode);
			}
		});
	
		Friends.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent FriendsList = new Intent(MainMenu.this, Friends.class);
				startActivity(FriendsList);
			}
		});
	}

	}

