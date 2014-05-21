package com.dnd.quancuatui;

import com.dnd.quancuatui.service.ServiceData;
import com.dnd.quancuatui.ultilities.Ultilities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class SplashActivity extends ActionBarActivity {

	SplashActivity instance = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();

		}
		
		instance = this;
		
		/*
		 *  test Add new user
		 */
		//ServiceData.instance.addNewUser(getDeviceID(), getModel(), get_OStype(), getDeviceID());
		
		/*
		 * test Get List Category
		 */
		//ServiceData.instance.getListCategory();
		
		/*
		 * test Get List Province
		 */
		//ServiceData.instance.getListProvince();
		
		/*
		 * test Get List District
		 */
		//ServiceData.instance.getListDistrict(1);//tp.hcm : 1
		
		/*
		 * test Add New Idea
		 */
		//ServiceData.instance.addNewIdea("Góp ý chức năng tìm kiếm", "Cho tìm kiếm giọng nói (test)");
	
		/*
		 * test Add Wrong Place
		 */
		//ServiceData.instance.addWrongPlace(getDeviceID(), "2"); // detailRestauntID = 2
		
		/*
		 * test Add Near Me
		 */
		//ServiceData.instance.addNearMe(getDeviceID(), 10.44131, 11.32313, "14,51,13", 3);
	
		/*
		 * test Get List Detail Restaurant
		 * DistrictID = 0  , categoryID = 5
		 */
		//ServiceData.instance.getListDetailRestaurantFromDistrictIdAndCategoryID(0, 5);
	
		/*
		 * test Get List Restaurant with Page (begin page = 0)
		 */
		//ServiceData.instance.getListDetailRestaurantWithPage(0);
		
		///////////////////////////////////////
		new loading().execute();
		
	}
	
	class loading extends AsyncTask<Void, Void, Void>{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			//check the first install app
			Ultilities.checkTheFirstInstallApp(instance);
			
			/*
			 * test Get List Category
			 */
			ServiceData.instance.getListCategory();
			
			/*
			 * test Get List Province
			 */
			ServiceData.instance.getListProvince();
			
			/*
			 * test Get List District
			 */
			ServiceData.instance.getListDistrict(1);//tp.hcm : 1
			
			/*
			 * test Get List Restaurant with Page (begin page = 0)
			 */
			ServiceData.instance.getListDetailRestaurantWithPage(0);
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			Intent intent = new Intent(instance,MainActivity.class);
			startActivity(intent);
		}
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
	
}

