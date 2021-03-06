/**
 * Copyright 2014-present topoos
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package topoos.Images;

import java.io.IOException;
import java.net.URLEncoder;

import android.content.Context;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.ImageUpload;
import topoos.APIAccess.Results.ImageResult;
import topoos.Exception.TopoosException;
import topoos.Objects.Image;

/**
 * The Class Translator.
 */
class Translator {

	/** The Constant SIZE_XXXSMALL. */
	public static final int SIZE_XXXSMALL = 0;

	/** The Constant SIZE_XXSMALL. */
	public static final int SIZE_XXSMALL = 1;

	/** The Constant SIZE_XSMALL. */
	public static final int SIZE_XSMALL = 2;

	/** The Constant SIZE_SMALL. */
	public static final int SIZE_SMALL = 3;

	/** The Constant SIZE_LARGE. */
	public static final int SIZE_LARGE = 4;

	/** The Constant SIZE_XLARGE. */
	public static final int SIZE_XLARGE = 5;

	/** The Constant SIZE_XXLARGE. */
	public static final int SIZE_XXLARGE = 6;

	/** The Constant SIZE_XXXLARGE. */
	public static final int SIZE_XXXLARGE = 7;

	/** The Constant PRIVACY_PUBLIC. */
	public static final int PRIVACY_PUBLIC = 0;
	/** The Constant PRIVACY_CLIENT. */
	public static final int PRIVACY_CLIENT = 1;
	/** The Constant PRIVACY_USER. */
	public static final int PRIVACY_USER = 2;

	/** The method_post. */
	private static String method_post = "POST";

	/** The format. */
	private static String format = "json";

	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * Image upload.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(byte[] file, String filename,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUpload",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * CVR Image upload.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param String
	 *            (required) privacy
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(byte[] file, String filename,
			AccessTokenOAuth accessTokenPregenerated, int privacy)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {

			String privacystr = "public";
			switch (privacy) {

			case PRIVACY_PUBLIC:
				privacystr = "public";
				break;
			case PRIVACY_CLIENT:
				privacystr = "client";
				break;
			case PRIVACY_USER:
				privacystr = "user";
				break;
			default:
				break;
			}

			ImageUpload imageUpload = new ImageUpload("ImageUpload",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					privacystr);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload position.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param pos_id
	 *            the pos_id
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPosition(byte[] file, String filename,
			Integer pos_id, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUploadPosition",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					pos_id, ImageUpload.TYPE_POS);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload poi.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param poi_id
	 *            the poi_id
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPOI(byte[] file, String filename,
			Integer poi_id, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUploadPOI",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					poi_id, ImageUpload.TYPE_POI);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload new poi.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param elevation
	 *            the elevation
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
	 * @param address
	 *            the address
	 * @param cross_street
	 *            the cross_street
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param postal_code
	 *            the postal_code
	 * @param phone
	 *            the phone
	 * @param twitter
	 *            the twitter
	 * @param categories
	 *            the categories
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadNewPOI(byte[] file, String filename,
			Double lat, Double lng, String name, String description,
			Integer elevation, Integer accuracy, Integer vaccuracy,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					if (i < categories.length - 1) {
						strcategories = strcategories + categories[i] + ",";
					} else {
						strcategories = strcategories + categories[i];
					}
				}
			}
			ImageUpload imageUpload = new ImageUpload("ImageUploadNewPOI",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					lat, lng, name, description, elevation, accuracy,
					vaccuracy, address, cross_street, city, country,
					postal_code, phone, twitter, strcategories);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(Context context, byte[] file,
			String filename) throws IOException, TopoosException {
		return ImageUpload(file, filename,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Image upload position.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param pos_id
	 *            the pos_id
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPosition(Context context, byte[] file,
			String filename, Integer pos_id) throws IOException,
			TopoosException {
		return ImageUploadPosition(file, filename, pos_id,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Image upload poi.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param poi_id
	 *            the poi_id
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPOI(Context context, byte[] file,
			String filename, Integer poi_id) throws IOException,
			TopoosException {
		return ImageUploadPOI(context, file, filename, poi_id);
	}

	/**
	 * Image upload new poi.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param elevation
	 *            the elevation
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
	 * @param address
	 *            the address
	 * @param cross_street
	 *            the cross_street
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param postal_code
	 *            the postal_code
	 * @param phone
	 *            the phone
	 * @param twitter
	 *            the twitter
	 * @param categories
	 *            the categories
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadNewPOI(Context context, byte[] file,
			String filename, Double lat, Double lng, String name,
			String description, Integer elevation, Integer accuracy,
			Integer vaccuracy, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter, Integer[] categories) throws IOException,
			TopoosException {
		return ImageUploadNewPOI(file, filename, lat, lng, name, description,
				elevation, accuracy, vaccuracy, address, cross_street, city,
				country, postal_code, phone, twitter, categories,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the image uri.
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @return the string
	 */
	public static String GetImageURI(String filename_unique) {
		String uri = APICaller.GetURLPICAPItopoos() + "/"
				+ URLEncoder.encode(filename_unique);
		return uri;
	}

	/**
	 * Gets the image uri thumb.
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @param size
	 *            the size
	 * 
	 * @return the string
	 */
	public static String GetImageURIThumb(String filename_unique, int size) {
		String strsize = "small";
		switch (size) {
		case SIZE_LARGE:
			strsize = "large";
			break;
		case SIZE_SMALL:
			strsize = "small";
			break;
		case SIZE_XLARGE:
			strsize = "x-large";
			break;
		case SIZE_XSMALL:
			strsize = "x-small";
			break;
		case SIZE_XXLARGE:
			strsize = "xx-large";
			break;
		case SIZE_XXSMALL:
			strsize = "xx-small";
			break;
		case SIZE_XXXLARGE:
			strsize = "xxx-large";
			break;
		case SIZE_XXXSMALL:
			strsize = "xxx-small";
			break;
		default:
			break;
		}
		String uri = APICaller.GetURLPICAPItopoos() + "/thumb/"
				+ URLEncoder.encode(filename_unique) + "?size="
				+ URLEncoder.encode(strsize);
		return uri;
	}

	/**
	 * Gets the image uri with privacy
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @param privacy
	 *            the privacy
	 * @return the string
	 */
	public static String GetImageURI(String filename_unique,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		String uri = null;
		if (accessTokenPregenerated.isValid()) {
			uri = APICaller.GetURLPICAPItopoos()
					+ "/"
					+ URLEncoder.encode(filename_unique)
					+ "?access_token="
					+ URLEncoder.encode(accessTokenPregenerated
							.getAccessToken());
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return uri;
	}

	/**
	 * Gets the image uri thumb with privacy.
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @param size
	 *            the size
	 * @param privacy
	 *            the privacy
	 * @return the string
	 */
	public static String GetImageURIThumb(String filename_unique, int size,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {

		String strsize = "small";
		String uri = null;
		switch (size) {
		case SIZE_LARGE:
			strsize = "large";
			break;
		case SIZE_SMALL:
			strsize = "small";
			break;
		case SIZE_XLARGE:
			strsize = "x-large";
			break;
		case SIZE_XSMALL:
			strsize = "x-small";
			break;
		case SIZE_XXLARGE:
			strsize = "xx-large";
			break;
		case SIZE_XXSMALL:
			strsize = "xx-small";
			break;
		case SIZE_XXXLARGE:
			strsize = "xxx-large";
			break;
		case SIZE_XXXSMALL:
			strsize = "xxx-small";
			break;
		default:
			break;
		}

		if (accessTokenPregenerated.isValid()) {

			uri = APICaller.GetURLPICAPItopoos()
					+ "/thumb/"
					+ URLEncoder.encode(filename_unique)
					+ "?size="
					+ URLEncoder.encode(strsize)
					+ "&access_token="
					+ URLEncoder.encode(accessTokenPregenerated
							.getAccessToken());
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return uri;
	}
}
