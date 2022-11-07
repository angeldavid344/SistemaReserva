package logica;

import java.sql.Date;

public class LReserva {
int IdReserva;
String Nombre;
Date Fecha;
String Hora;
String Telefono;
String Sala;
String Usuario;
String Estado;

public LReserva() {
	
}

public LReserva(int idReserva, String nombre, Date fecha, String hora, String telefono, String sala, String usuario,
		String estado) {
	super();
	IdReserva = idReserva;
	Nombre = nombre;
	Fecha = fecha;
	Hora = hora;
	Telefono = telefono;
	Sala = sala;
	Usuario = usuario;
	Estado = estado;
}

public int getIdReserva() {
	return IdReserva;
}
public void setIdReserva(int idReserva) {
	IdReserva = idReserva;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public Date getFecha() {
	return Fecha;
}
public void setFecha(Date fecha) {
	Fecha = fecha;
}
public String getHora() {
	return Hora;
}
public void setHora(String hora) {
	Hora = hora;
}
public String getTelefono() {
	return Telefono;
}
public void setTelefono(String telefono) {
	Telefono = telefono;
}
public String getSala() {
	return Sala;
}
public void setSala(String sala) {
	Sala = sala;
}
public String getUsuario() {
	return Usuario;
}
public void setUsuario(String usuario) {
	Usuario = usuario;
}
public String getEstado() {
	return Estado;
}
public void setEstado(String estado) {
	Estado = estado;
}
	
	
}
