package com.example.wb;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Initialize extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_time);
		
		final EditText name = (EditText) findViewById(R.id.enter_name);
		final Button next = (Button) findViewById(R.id.next);
		
		SharedPreferences prefs = getSharedPreferences("com.example.wb", 0);
		boolean name_exists = prefs.contains("username");
		final SharedPreferences.Editor edit = prefs.edit();

		if(!name_exists) 
		{
			final boolean available = true;
			
			next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// check with server if name is available
					if (available)
					{
						edit.putString("username", name.getText().toString());
						edit.putInt("wins", 0);
						edit.putInt("games", 0);
						edit.putInt("coins", 0);
						edit.apply();
						
						Intent mainMenu = new Intent(Initialize.this, MainMenu.class);
						startActivity(mainMenu);
						finish();
					}
				}
			});
		}
		else
		{
			Intent mainMenu = new Intent(this, MainMenu.class);
			startActivity(mainMenu);
			finish();
		}

	
}
}
