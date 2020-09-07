package co.edu.ucentral.relojeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reloj")
public class Reloj {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String marca;
	private int precio;
	@Column(name="descripción")
	private String descripcion;
	private int cantidad;
	@OneToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	private int imagen;
	
	public Reloj() {
		
	}
	
	public Reloj(String nombre, String marca, int precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Categoria  getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria  categoria) {
		this.categoria = categoria;
	}
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Reloj [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", categoria=" + categoria + ", imagen=" + imagen + "]";
	}
}
