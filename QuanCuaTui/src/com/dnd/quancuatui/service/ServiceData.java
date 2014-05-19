package com.dnd.quancuatui.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ClipData.Item;
import android.graphics.Bitmap;
import android.provider.Telephony.Sms;
import android.util.Log;

public class ServiceData extends Service {
	// TODO instance
	public static ServiceData instance = new ServiceData();

	// TODO Resources
	public final static String ADD_NEW_USER = "AddUser.php";
	public final static String GET_LIST_CATEGORY = "GetListCategory.php";

	public ServiceData() {

	}

	@Override
	public String getDataJson(String info, String link) {
		return super.getDataJson(info, link);
	}

	/*
	 * Add new user
	 */
	public void addNewUser(String deveiceID, String model, String ostype,
			String imei) {
		VALUE = TOKEN + AND + deveiceID + AND + model + AND + ostype + AND
				+ imei;
		LINK = HOST + ADD_NEW_USER;
		DATA = getDataJson(VALUE, LINK);
	}

	/*
	 * get list category
	 */
	public void getListCategory() {
		VALUE = TOKEN;
		LINK  = HOST + GET_LIST_CATEGORY;
		DATA = getDataJson(VALUE, LINK);
		
		
	}

}
