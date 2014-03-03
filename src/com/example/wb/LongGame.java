package com.example.wb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LongGame extends Activity {

	int add = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.long_game);
		
		final Button build = (Button) findViewById(R.id.buildButton);
		final ImageButton buttonA = (ImageButton) findViewById(R.id.buttonA);
		final ImageButton buttonB = (ImageButton) findViewById(R.id.buttonB);
		final ImageButton buttonC = (ImageButton) findViewById(R.id.buttonC);
		final ImageButton buttonD = (ImageButton) findViewById(R.id.buttonD);
		final ImageButton buttonE = (ImageButton) findViewById(R.id.buttonE);
		final ImageButton buttonF = (ImageButton) findViewById(R.id.buttonF);
		final ImageButton buttonG = (ImageButton) findViewById(R.id.buttonG);
		final ImageButton buttonH = (ImageButton) findViewById(R.id.buttonH);
		final ImageButton buttonI = (ImageButton) findViewById(R.id.buttonI);
		final ImageButton buttonJ = (ImageButton) findViewById(R.id.buttonJ);
		final ImageButton buttonK = (ImageButton) findViewById(R.id.buttonK);
		final ImageButton buttonL = (ImageButton) findViewById(R.id.buttonL);
		final ImageButton buttonM = (ImageButton) findViewById(R.id.buttonM);
		final ImageButton buttonN = (ImageButton) findViewById(R.id.buttonN);
		final ImageButton buttonO = (ImageButton) findViewById(R.id.buttonO);
		final ImageButton buttonP = (ImageButton) findViewById(R.id.buttonP);
		final ImageButton buttonQ = (ImageButton) findViewById(R.id.buttonQ);
		final ImageButton buttonR = (ImageButton) findViewById(R.id.buttonR);
		final ImageButton buttonS = (ImageButton) findViewById(R.id.buttonS);
		final ImageButton buttonT = (ImageButton) findViewById(R.id.buttonT);
		final ImageButton buttonU = (ImageButton) findViewById(R.id.buttonU);
		final ImageButton buttonV = (ImageButton) findViewById(R.id.buttonV);
		final ImageButton buttonW = (ImageButton) findViewById(R.id.buttonW);
		final ImageButton buttonX = (ImageButton) findViewById(R.id.buttonX);
		final ImageButton buttonY = (ImageButton) findViewById(R.id.buttonY);
		final ImageButton buttonZ = (ImageButton) findViewById(R.id.buttonZ);
		final Button buttonQuit = (Button) findViewById(R.id.buttonQuit);
		final TextView centerWord = (TextView) findViewById(R.id.centerWord);
		
		buttonA.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "a";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "a";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}

			}
		});
		
		buttonB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "b";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "b";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}

			}
		});
		
		buttonC.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "c";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "c";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}

			}
		});
		
		buttonD.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "d";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "d";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonE.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "e";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "e";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		

		buttonF.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "f";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "f";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonG.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "g";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "g";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonH.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "h";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "h";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonI.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "i";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "i";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonJ.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "j";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "j";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonK.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "k";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "k";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonL.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "l";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "l";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "m";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "m";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "n";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "n";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonO.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "o";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "o";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "p";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "p";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonQ.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "q";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "q";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonR.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "r";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "r";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonS.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "s";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "s";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonT.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "t";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "t";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonU.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "u";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "u";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "v";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "v";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonW.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "w";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "w";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonX.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "x";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "x";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonY.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "y";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "y";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		buttonZ.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0){
					String word = centerWord.getText().toString();
					String word2 = word + "z";
					SpannableString word3 = new SpannableString(word2); 
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);
					centerWord.setText(word3, BufferType.SPANNABLE);
				
					add = 1;
				}
				else if (add == 1) {
					String word = centerWord.getText().toString();
					word = word.substring(0,word.length()-1);
					String word2 = word + "z";
					SpannableString word3 = new SpannableString(word2);
					word3.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word3.length()-1, 0);
					word3.setSpan(new ForegroundColorSpan(Color.BLUE), word3.length()-1, word3.length(), 0);  
					centerWord.setText(word3, BufferType.SPANNABLE);
				}
			}
		});
		
		
		
		build.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (add == 0) {
					
				}
				if (add == 1) {
					add = 0;
					String word = centerWord.getText().toString();
					SpannableString word2 = new SpannableString(word); 
					word2.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 0, word2.length(), 2);   
					centerWord.setText(word2, BufferType.SPANNABLE);
				}
				
			}
		});
		
		buttonQuit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent quit = new Intent(LongGame.this, GameOver.class);
				startActivity(quit);
				finish();
			}
		});
	
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game__screen_, menu);
		return true;
	}

}
