package com.dnd.quancuatui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dnd.quancuatui.service.ServiceData;

public class SplashActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();

		}
		
		/*
		 *  test Add new user
		 */
		ServiceData.instance.addNewUser(getDeviceID(), getModel(), get_OStype(), getDeviceID());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	/*
	 * get device ID
	 */
	public String getDeviceID() {
		String identifier = null;
		TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		if (tm != null)
		      identifier = tm.getDeviceId();
		if (identifier == null || identifier .length() == 0)
		      identifier = Secure.getString(getContentResolver(),Secure.ANDROID_ID);
		
		return identifier;
	}
	
	/*
	 * get model device
	 */
	public String getModel(){
		return android.os.Build.MODEL;
	}

	/*
	 * get os type
	 */
	public String get_OStype(){
		return "Android " + Build.VERSION.SDK_INT;
	}
	
	
}

