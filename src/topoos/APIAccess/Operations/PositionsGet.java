package topoos.APIAccess.Operations;

public class PositionsGet extends APIOperation{



	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	posid=null; // (obligatorio) identificador de una posici�n concreta.
	private String	usr=null; // (opcional) identificador del usuario, si no se indica se obtendr� la �ltima posici�n del usuario actual
	private String	device=null; // (obligatorio) identificador del dispositivo del cual vamos a obtener la �ltima posici�n.
	

	
	public PositionsGet(String operationName, String method, String format,
			Integer version, String oauth_token, String posid, String usr, String device
			) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.posid = posid;
		this.usr = usr;
		this.device = device;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate &&(isValid(posid)||isValid(usr)||isValid(device));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			if(isValid(posid)){
				params = "/" + this.Version + "/positions/get."
					+ this.Format + "?oauth_token=" + this.oauth_token+"&posid="+posid;
			}else if (isValid(usr)){
				params = "/" + this.Version + "/positions/get."
						+ this.Format + "?oauth_token=" + this.oauth_token+"&usr="+usr;				
			}else if (isValid(device)){
				params = "/" + this.Version + "/positions/get."
						+ this.Format + "?oauth_token=" + this.oauth_token+"&device="+device;				
			}
		}
		return params;
	}

}
