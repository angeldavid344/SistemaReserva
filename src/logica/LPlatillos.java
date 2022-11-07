package logica;

public class LPlatillos {
private int IdPlatillos;
private String Nombre;
private Double Costo;

public LPlatillos(int idPlatillos, String nombre, Double costo) {
	super();
	IdPlatillos = idPlatillos;
	Nombre = nombre;
	Costo = costo;
}
public LPlatillos() {
	// TODO Auto-generated constructor stub
}
public int getIdPlatillos() {
	return IdPlatillos;
}
public void setIdPlatillos(int idPlatillos) {
	IdPlatillos = idPlatillos;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public Double getCosto() {
	return Costo;
}
public void setCosto(Double costo) {
	Costo = costo;
}
	
}
