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

package topoos.APIAccess.Results;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class PositionResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class PositionResult extends APICallResult {

	/** The position. */
	private Position position = null;

	/**
	 * Instantiates a new position result.
	 */
	public PositionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new position result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public PositionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new position result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param position
	 *            the position
	 */
	public PositionResult(String error, String result, Position position) {
		super(error, result);
		this.position = position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id = null;
		String device = null;
		Date timestamp = null;
		Date registerTime = null;
		Double latitude = null;
		Double longitude = null;
		Double elevation = null;
		PositionType positionType = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Double bearing = null;
		Double velocity = null;
		String track_id = null;
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {

				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				id = APIUtils.getIntegerorNull(jObject, "id");
				device = APIUtils.getStringorNull(jObject, "device");
				latitude = APIUtils.getDoubleorNull(jObject, "latitude");
				longitude = APIUtils.getDoubleorNull(jObject, "longitude");
				elevation = APIUtils.getDoubleorNull(jObject, "elevation");
				accuracy = APIUtils.getDoubleorNull(jObject, "accuracy");
				vaccuracy = APIUtils.getDoubleorNull(jObject, "vaccuracy");
				bearing = APIUtils.getDoubleorNull(jObject, "bearing");
				velocity = APIUtils.getDoubleorNull(jObject, "velocity");
				track_id = APIUtils.getStringorNull(jObject, "track_id");
				timestamp = APIUtils.toDateString(jObject
						.getString("timestamp"));
				registerTime = APIUtils.toDateString(jObject
						.getString("registerTime"));
				positionType = new PositionType(APIUtils.getStringorNull(
						jObject.getJSONObject("position_type"), "id"),
						APIUtils.getStringorNull(
								jObject.getJSONObject("position_type"),
								"description"));

				this.position = new Position(id, device, timestamp,
						registerTime, latitude, longitude, elevation,
						positionType, accuracy, vaccuracy, bearing, velocity,
						track_id);
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 * 
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

}