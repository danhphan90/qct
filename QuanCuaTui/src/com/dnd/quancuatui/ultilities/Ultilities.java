package com.dnd.quancuatui.ultilities;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

import com.dnd.quancuatui.service.ServiceData;

public class Ultilities {

	public final static String file_the_first_install_app = "thefirst.txt";

	/*
	 * get device ID
	 */
	public static String getDeviceID(Context context) {
		String identifier = null;
		TelephonyManager tm = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		if (tm != null)
			identifier = tm.getDeviceId();
		if (identifier == null || identifier.length() == 0)
			identifier = Secure.getString(context.getContentResolver(),
					Secure.ANDROID_ID);

		return identifier;
	}

	/*
	 * get model device
	 */
	public static String getModel() {
		return android.os.Build.MODEL;
	}

	/*
	 * get os type
	 */
	public static String get_OStype() {
		return "Android " + Build.VERSION.SDK_INT;
	}

	/*
	 * check connect Internet
	 */
	public static boolean checkConnectInternet(Context context) {
		boolean isConnect = false;
		ConnectivityManager connMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connMgr.getActiveNetworkInfo() != null
				&& connMgr.getActiveNetworkInfo().isAvailable()
				&& connMgr.getActiveNetworkInfo().isConnected()) {
			isConnect = true;
		} else {
			isConnect = false;
		}
		return isConnect;
	}

	/*
	 * check the first install app
	 */
	public static void checkTheFirstInstallApp(Context context) {
		if (!FileManager.fileIsExits((Activity) context,
				file_the_first_install_app)) {
			/*
			 * Add new user to service
			 */
			ServiceData.instance.addNewUser(getDeviceID(context), getModel(),
					get_OStype(), getDeviceID(context));
			FileManager.saveUserID((Activity) context, "success",
					file_the_first_install_app);
		}
	}
}
