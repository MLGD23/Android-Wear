package mx.octaviocervantes.mypetcare.datos;

public class MascotaInstagram{

	private String idUsuario;
	private String nombreUsuario;
	private String urlFoto;
	private int meGusta = 0;

	public MascotaInstagram(String nombreUsuario, String urlFoto, int meGusta) {
		this.nombreUsuario = nombreUsuario;
		this.urlFoto = urlFoto;
		this.meGusta = meGusta;
	}

	public MascotaInstagram(){}

	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public int getMeGusta() {
		return meGusta;
	}
	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}

}