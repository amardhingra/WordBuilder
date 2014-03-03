package com.example.wb;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class StringOps {
	
	public StringOps(){}

	public SpannableString changeLetter(String word, String letter)
	{
		word = word.substring(0,word.length()-1);
		String word2 = word + letter;
		SpannableString wordSpan = new SpannableString(word2); 
		int len = wordSpan.length();
		wordSpan.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, len-1, 0);
		wordSpan.setSpan(new ForegroundColorSpan(Color.BLUE), len-1, len, 0);
		return wordSpan;
	}
	
	public SpannableString addLetter(String word, String letter, boolean challenge_mode)
	{
		int len = word.length();
		String word2 = word + letter;
		SpannableString ws = new SpannableString(word2);
		if (challenge_mode)
		{
			ws.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, len, 0);
			ws.setSpan(new ForegroundColorSpan(Color.BLUE), len, ws.length(), 0);
		}
		else if (!challenge_mode)
		{
			ws.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, ws.length()-1, 0);
			ws.setSpan(new ForegroundColorSpan(Color.BLUE), ws.length()-1, ws.length(), 0);
		}
		return ws;
	}
	
	public SpannableString toPurple(SpannableString word)
	{
		word.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, word.length(), 0);
		return word;
	}
	
	public SpannableString toPurple(SpannableString word, int fromLength)
	{
		word.setSpan(new ForegroundColorSpan(Color.rgb(138, 43, 226)), 0, fromLength, word.length());
		return word;
	}
	
	
}
