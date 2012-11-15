package topoos.POIWarning;

import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.APIAccess.Results.Objects.*;

class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static List<POIDataWarning> Get(Integer[] POIID, String type,
			AccessTokenOAuth accessTokenPregenerated) {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			String strPOIID = "";
			for (int i = 0; i < POIID.length; i++) {
				if (i < POIID.length - 1) {
					strPOIID = strPOIID + POIID[i] + ",";
				} else {
					strPOIID = strPOIID + POIID[i];
				}
			}
			POISWarning pOISWarning = new POISWarning("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					strPOIID, type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		}
		return pOIWarning;
	}

	public static List<POIDataWarning> GetAll(String type,
			AccessTokenOAuth accessTokenPregenerated) {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarning pOISWarning = new POISWarning("GetAll", method, format,
					version, accessTokenPregenerated.getAccessToken(), null,
					type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		}
		return pOIWarning;
	}

	public static POIWarning AddClosed(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddClosed",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_CLOSED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		}
		return pOIWarning;
	}

	public static POIWarning AddDuplicated(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("GetAll",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_DUPLICATED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		}
		return pOIWarning;
	}

	public static POIWarning AddWrongIndicator(Integer POI_ID, Double lat,
			Double lng, Double accuracy, Double vaccuracy, Double elevation,
			AccessTokenOAuth accessTokenPregenerated) {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddWrongIndicator",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INDICATOR, lat, lng, accuracy,
					vaccuracy, elevation);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		}
		return pOIWarning;
	}

	public static POIWarning AddWrongInfo(Integer POI_ID, String name,
			Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			AccessTokenOAuth accessTokenPregenerated) {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			for (int i = 0; i < categories.length; i++) {
				if (i < categories.length - 1) {
					strcategories = strcategories + categories[i] + ",";
				} else {
					strcategories = strcategories + categories[i];
				}
			}
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddWrongInfo",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INFO, strcategories, name, desc,
					address, cross_street, city, country, postal_code, phone,
					twitter);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		}
		return pOIWarning;
	}

	public static Boolean Delete(Integer POIID, String type,
			AccessTokenOAuth accessTokenPregenerated) {

	}

	public static Boolean DeleteAll(String type,
			AccessTokenOAuth accessTokenPregenerated) {

	}

	public static List<POIDataWarning> Get(Context context, Integer[] POIID,
			String type) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Get(POIID, type, accessTokenPregenerated);
	}

	public static List<POIDataWarning> GetAll(Context context, String type) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetAll(type, accessTokenPregenerated);
	}

	public static POIWarning AddClosed(Context context, Integer POI_ID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddClosed(POI_ID, accessTokenPregenerated);
	}

	public static POIWarning AddDuplicated(Context context, Integer POI_ID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddDuplicated(POI_ID, accessTokenPregenerated);
	}

	public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddWrongIndicator(POI_ID, lat, lng, accuracy, vaccuracy,
				elevation, accessTokenPregenerated);
	}

	public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddWrongInfo(POI_ID, name, categories, desc, address,
				cross_street, city, country, postal_code, phone, twitter,
				accessTokenPregenerated);
	}

	public static Boolean Delete(Context context, Integer POIID, String type) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Delete(POIID, type, accessTokenPregenerated);
	}

	public static Boolean DeleteAll(Context context, String type) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return DeleteAll(type, accessTokenPregenerated);
	}
}