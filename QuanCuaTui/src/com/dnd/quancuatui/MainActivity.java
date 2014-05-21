package com.dnd.quancuatui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.i("MainActivity::onCreate", "OK");
	}
}
