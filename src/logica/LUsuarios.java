package logica;

public class LUsuarios {
	private int IdUsuarios;
	private String Nombre;
	private String APaterno;
	private String Amaterno;
	private String Usuario;
	private String Clave;
	private String Perfil;
	
	public LUsuarios() {
		
	}
	
	public LUsuarios(int idUsuarios, String nombre, String aPaterno, String amaterno, String usuario, String clave,
			String perfil) {
		super();
		IdUsuarios = idUsuarios;
		Nombre = nombre;
		APaterno = aPaterno;
		Amaterno = amaterno;
		Usuario = usuario;
		Clave = clave;
		Perfil = perfil;
	}
	public int getIdUsuarios() {
		return IdUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		IdUsuarios = idUsuarios;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getAPaterno() {
		return APaterno;
	}

	public void setAPaterno(String aPaterno) {
		APaterno = aPaterno;
	}

	public String getAmaterno() {
		return Amaterno;
	}

	public void setAmaterno(String amaterno) {
		Amaterno = amaterno;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}	
	
}
