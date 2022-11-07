package logica;

import java.sql.Date;

public class Lventas {
	int Id;
	int IdR;
	String Nombre;
	Date Fecha;
		String Hora;
	public Lventas() {
		
	}
	public Lventas(int id, int idR, Date fecha, String hora) {
		super();
		Id = id;
		IdR = idR;
		Hora = hora;
		Fecha = fecha;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdR() {
		return IdR;
	}
	public void setIdR(int idR) {
		IdR = idR;
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
	
}
