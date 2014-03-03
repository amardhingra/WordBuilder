package com.example.wb;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class GameOver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_over);
	
	
	Button again = (Button) findViewById(R.id.buttonReplay);
	Button newPlayer = (Button) findViewById(R.id.buttonNewPlayer);
	
	again.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent againShort = new Intent(GameOver.this, ShortGame.class);
			startActivity(againShort);
			finish();
		}
	});
	
	newPlayer.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent main = new Intent(GameOver.this,MainMenu.class);
			startActivity(main);
			finish();
		}
	});
	
	}
}
