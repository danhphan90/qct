package com.dnd.quancuatui.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dnd.quancuatui.model.Category;
import com.dnd.quancuatui.model.DetailRestaurant;
import com.dnd.quancuatui.model.District;
import com.dnd.quancuatui.model.Provine;

public class ServiceData extends Service {
	// TODO instance
	public static ServiceData instance = new ServiceData();

	// TODO Resources
	public final static String ADD_NEW_USER = "AddUser.php";
	public final static String GET_LIST_CATEGORY = "GetListCategory.php";
	public final static String GET_LIST_PROVINCE = "GetListProvince.php";
	public final static String GET_LIST_DISTRICT = "GetListDistrict.php";
	public final static String ADD_NEW_IDEA = "AddIdea.php";
	public final static String ADD_WRONG_PLACE = "AddWrongPlace.php";
	public final static String ADD_NEAR_ME = "AddNearMe.php";
	public final static String GET_LIST_RESTAURANT_WITH_DISTRICTID_AND_CATEGORYID = "GetListRestaurantWithDistrictidAndCategoryid.php";
	public final static String GET_LIST_RESTAURANT_WITH_PAGE = "GetListRestaurantWithPage.php";

	// TODO Variables
	public ArrayList<Category> list_category = new ArrayList<Category>();
	public ArrayList<Provine> list_province = new ArrayList<Provine>();
	public ArrayList<District> list_district = new ArrayList<District>();
	public ArrayList<DetailRestaurant> list_restaurant = new ArrayList<DetailRestaurant>();
	public ArrayList<DetailRestaurant> list_restaurant_with_page = new ArrayList<DetailRestaurant>();
	
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
		LINK = HOST_SERVICE + ADD_NEW_USER;
		DATA = getDataJson(VALUE, LINK);
	}

	/*
	 * get list category
	 */
	public void getListCategory() {
		VALUE = TOKEN;
		LINK = HOST_SERVICE + GET_LIST_CATEGORY;
		DATA = getDataJson(VALUE, LINK);

		JSONObject obj;
		try {
			obj = new JSONObject(DATA);

			DATA = obj.getString("list_category");

			list_category = new ArrayList<Category>();
			JSONArray json = null;
			try {
				json = new JSONArray(DATA);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < json.length(); i++) {
				Category item = new Category();
				try {
					JSONObject j = json.getJSONObject(i);
					item.setCategoryID(j.getInt("categoryID"));
					item.setName(j.getString("name"));
				} catch (JSONException e) {
					e.printStackTrace();
				} finally {
					list_category.add(item);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/*
	 * get list province
	 */
	public void getListProvince() {
		VALUE = TOKEN;
		LINK = HOST_SERVICE + GET_LIST_PROVINCE;
		DATA = getDataJson(VALUE, LINK);

		JSONObject obj;
		try {
			obj = new JSONObject(DATA);

			DATA = obj.getString("list_province");

			list_province = new ArrayList<Provine>();
			JSONArray json = null;
			try {
				json = new JSONArray(DATA);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < json.length(); i++) {
				Provine item = new Provine();
				try {
					JSONObject j = json.getJSONObject(i);
					item.setProvinceID(j.getInt("provinceID"));
					item.setName(j.getString("name"));
				} catch (JSONException e) {
					e.printStackTrace();
				} finally {
					list_province.add(item);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/*
	 * get list district
	 */
	public void getListDistrict(int provinceID) {
		VALUE = TOKEN + AND + provinceID;
		LINK = HOST_SERVICE + GET_LIST_DISTRICT;
		DATA = getDataJson(VALUE, LINK);

		JSONObject obj;
		try {
			obj = new JSONObject(DATA);

			DATA = obj.getString("list_district");

			list_district = new ArrayList<District>();
			JSONArray json = null;
			try {
				json = new JSONArray(DATA);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < json.length(); i++) {
				District item = new District();
				try {
					JSONObject j = json.getJSONObject(i);
					item.setDistricID(j.getInt("districtID"));
					item.setName(j.getString("name"));
				} catch (JSONException e) {
					e.printStackTrace();
				} finally {
					list_district.add(item);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/*
	 * Add new idea
	 */
	public void addNewIdea(String title, String content) {
		VALUE = TOKEN + AND + title + AND + content;
		LINK = HOST_SERVICE + ADD_NEW_IDEA;
		DATA = getDataJson(VALUE, LINK);
	}

	/*
	 * Add wrong place
	 */
	public void addWrongPlace(String deviceID, String detailRestaurantID) {
		VALUE = TOKEN + AND + deviceID + AND + detailRestaurantID;
		LINK = HOST_SERVICE + ADD_WRONG_PLACE;
		DATA = getDataJson(VALUE, LINK);
	}
	
	/*
	 * Add near me
	 */
	public void addNearMe(String deviceID, Double longtitude,Double latitude,String location,int numberLocation) {
		VALUE = TOKEN + AND + deviceID + AND + longtitude + AND + latitude + AND + location + AND + numberLocation;
		LINK = HOST_SERVICE + ADD_NEAR_ME;
		DATA = getDataJson(VALUE, LINK);
	}

	
	/*
	 * get list detail restaurant from DistrictID and CategoryID
	 */
	public void getListDetailRestaurantFromDistrictIdAndCategoryID(int districtID,int categoryID) {
		VALUE = TOKEN + AND + districtID + AND + categoryID;
		LINK = HOST_SERVICE + GET_LIST_RESTAURANT_WITH_DISTRICTID_AND_CATEGORYID;
		DATA = getDataJson(VALUE, LINK);

		JSONObject obj;
		try {
			obj = new JSONObject(DATA);

			DATA = obj.getString("list_restaurant");

			list_restaurant = new ArrayList<DetailRestaurant>();
			JSONArray json = null;
			try {
				json = new JSONArray(DATA);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < json.length(); i++) {
				DetailRestaurant item = new DetailRestaurant();
				try {
					JSONObject j = json.getJSONObject(i);
					item.setDetailID(Integer.parseInt(j.getString("detailID")));
					item.setDistrictID(Integer.parseInt(j.getString("districtID")));
					item.setCategoryID(Integer.parseInt(j.getString("categoryID")));
					item.setTitle(j.getString("title"));
					item.setAddress(j.getString("address"));
					item.setTime(j.getString("time"));
					item.setPrice(j.getString("price"));
					item.setLongitude(Double.parseDouble(j.getString("longitude")));
					item.setLatitude(Double.parseDouble(j.getString("latitude")));
					item.setDetailInfo(j.getString("detailInfo"));
					item.setAdvantage(j.getString("advantage"));
					item.setDisadvantage(j.getString("disadvantage"));
					item.setRate(Float.parseFloat(j.getString("rate")));
					item.setNumberLike(Integer.parseInt(j.getString("numberLike")));
					item.setNumberShare(Integer.parseInt(j.getString("numberShare")));
					item.setAvatar_link(j.getString("avatar"));
					
					String images = j.getString("images");
					String[] list_images = images.split("\n");
					item.setList_image_links(list_images);
		
				} catch (JSONException e) {
					e.printStackTrace();
				} finally {
					list_restaurant.add(item);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	/*
	 * get list detail restaurant with Page
	 */
	public void getListDetailRestaurantWithPage(int page) {
		VALUE = TOKEN + AND + page;
		LINK = HOST_SERVICE + GET_LIST_RESTAURANT_WITH_PAGE;
		DATA = getDataJson(VALUE, LINK);

		JSONObject obj;
		try {
			obj = new JSONObject(DATA);

			DATA = obj.getString("list_restaurant");

			list_restaurant = new ArrayList<DetailRestaurant>();
			JSONArray json = null;
			try {
				json = new JSONArray(DATA);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < json.length(); i++) {
				DetailRestaurant item = new DetailRestaurant();
				try {
					JSONObject j = json.getJSONObject(i);
					item.setDetailID(Integer.parseInt(j.getString("detailID")));
					item.setDistrictID(Integer.parseInt(j.getString("districtID")));
					item.setCategoryID(Integer.parseInt(j.getString("categoryID")));
					item.setTitle(j.getString("title"));
					item.setAddress(j.getString("address"));
					item.setTime(j.getString("time"));
					item.setPrice(j.getString("price"));
					item.setLongitude(Double.parseDouble(j.getString("longitude")));
					item.setLatitude(Double.parseDouble(j.getString("latitude")));
					item.setDetailInfo(j.getString("detailInfo"));
					item.setAdvantage(j.getString("advantage"));
					item.setDisadvantage(j.getString("disadvantage"));
					item.setRate(Float.parseFloat(j.getString("rate")));
					item.setNumberLike(Integer.parseInt(j.getString("numberLike")));
					item.setNumberShare(Integer.parseInt(j.getString("numberShare")));
					item.setAvatar_link(j.getString("avatar"));
					
					String images = j.getString("images");
					String[] list_images = images.split("\n");
					item.setList_image_links(list_images);
		
				} catch (JSONException e) {
					e.printStackTrace();
				} finally {
					list_restaurant.add(item);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
