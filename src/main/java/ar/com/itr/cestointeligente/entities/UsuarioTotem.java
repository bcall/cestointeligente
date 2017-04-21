package ar.com.itr.cestointeligente.entities;

public class UsuarioTotem {
	
	
	private long id;
	private String qrCode;
	private String email;
	private String telefono;
	private String nombre;
	private String password;
//	private TipoUsuario tipoUsuario;
//	private GrupoUsuario grupoUsuario;
	
	private long pesoA;
	private long pesoB;
	private long pesoC;
	private long puntos;

	
	public UsuarioTotem(){
		
	}
	
	public UsuarioTotem(String qrCode){
		this.qrCode = qrCode;
	}
	
	public UsuarioTotem(long id, String email, String nombre, String password) {
		this.id = id;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public TipoUsuario getTipoUsuario() {
//		return tipoUsuario;
//	}
//	public void setTipoUsuario(TipoUsuario tipoUsuario) {
//		this.tipoUsuario = tipoUsuario;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public GrupoUsuario getGrupoUsuario() {
//		return grupoUsuario;
//	}
//
//	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
//		this.grupoUsuario = grupoUsuario;
//	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public long getPesoA() {
		return pesoA;
	}

	public void setPesoA(long pesoA) {
		this.pesoA = pesoA;
	}

	public long getPesoB() {
		return pesoB;
	}

	public void setPesoB(long pesoB) {
		this.pesoB = pesoB;
	}

	public long getPesoC() {
		return pesoC;
	}

	public void setPesoC(long pesoC) {
		this.pesoC = pesoC;
	}

	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}
	
}
