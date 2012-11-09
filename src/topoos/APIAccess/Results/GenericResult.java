package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;


public class GenericResult extends APICallResult {

	private String code=null;
	private String description=null;

	public GenericResult() {
		super();
	}

	public GenericResult(String error, String result) {
		super(error, result);
	}

	public GenericResult(String error, String result, String code,
			String description) {
		super(error, result);
		this.code = code;
		this.description = description;
	}

	@Override
	public void setParameters() {
		// Processing result
				try {
					JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
							.nextValue();
					this.code=jObject.getString("code");
					this.description=jObject.getString("description");
				}catch (Exception e) {
					// TODO: handle exception
				}
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
