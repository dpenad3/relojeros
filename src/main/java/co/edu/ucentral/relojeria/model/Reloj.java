package co.edu.ucentral.relojeria.model;

public class Reloj {

	private String nombre;
	private String marca;
	private int precio;
	private String descripcion;
	private int cantidad;
	private int categoria;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Reloj [nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", cantidad=" + cantidad + ", categoria=" + categoria + "]";
	}
}
