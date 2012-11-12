package topoos.APIAccess.Operations;

import java.util.Date;


public class PositionsAdd extends APIOperation{

	

	public static final int TRACK_END =	2; 
	public static final int POS =	3; 
	public static final int ALARM_INIT = 6;
	public static final int ALARM_END =	7; 
	public static final int GPS_OK = 8; 
	
	
	private String oauth_token=null; // (obligatorio)access_token de Acceso a recursos
	private String	device=null; // (opcional) dispositivo que captur� la posici�n. Se trata de un par�metro obligatorio cuando la aplicaci�n puede manejar los dispositivos f�sicos de un usuario, opci�n que por defecto est� deshabilitada.
	private Double	lat=null; // (obligatorio) latitud en grados decimales de la nueva posici�n
	private Double	lng=null; // (obligatorio) longitud en grados decimales de la nueva posici�n
	private String	accuracy=null; // (opcional) precisi�n de la posici�n (latitud, longitud)
	private String	vaccuracy=null; // (opcional) precisi�n de la elevaci�n
	private String	elevation=null; // (opcional) elevaci�n respecto al nivel del mar
	private Date	timestamp=null; // (opcional) hora local con offset de conversi�n UTC de captura de la posici�n, seg�n el est�ndar ISO 8601.
	 //(AAAA-MM-DDThh:mm:sszzzzzz) en UTC
	 //ejemplo: 1997-07-16T10:30:15.342+03:00
	private String	velocity=null; // (opcional) velocidad de movimiento en el instante en que se captur� la posici�n, en metros por segundo
	private Integer	postype=null; //(opcional) tipo de posici�n a registrar
	private String	bearing=null; // (opcional) rumbo de movimiento (valor entre 0 y 360)
	private String	track=null; // (opcional) identificador del Track al que pertenece la posici�n (excepto cuando es TRACK_INIT)

	public PositionsAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng, String device,
			String accuracy, String vaccuracy, String elevation,
			Date timestamp, String velocity, Integer postype, String bearing,
			String track) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.device= device;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.timestamp = timestamp;
		this.velocity = velocity;
		this.postype = postype;
		this.bearing = bearing;
		this.track = track;
	}
	
	@Override
	public boolean ValidateParams() {

		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(accuracy);
		validate = validate && isValidorNull(vaccuracy);
		validate = validate && isValidorNull(elevation);
		validate = validate && isValidorNull(APIUtils.toStringDate(timestamp));
		validate = validate && isValidorNull(velocity);
		validate = validate && isValidorNull(APIUtils.toStringInteger(postype));
		validate = validate && isValidorNull(bearing);
		validate = validate && isValidorNull(track);
		return validate;
	}

	@Override
	public String ConcatParams() {

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/add." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&lat="+APIUtils.toStringDouble(lat)
					+ "&lng="+APIUtils.toStringDouble(lng)
					+(device == null? "" : "&device="+device)
					+(accuracy == null? "" : "&accuracy="+accuracy)
					+(vaccuracy == null? "" : "&vaccuracy="+vaccuracy)
					+(elevation == null? "" : "&elevation="+elevation)
					+(timestamp == null? "" : "&timestamp="+APIUtils.toStringDate(timestamp))
					+(velocity == null? "" : "&velocity="+velocity)
					+(postype == null? "" : "&postype="+APIUtils.toStringInteger(postype))
					+(bearing == null? "" : "&bearing="+bearing)
					+(track == null? "" : "&track="+track)
					;
		}
		return params;
	}
	

		
}
