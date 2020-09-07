package co.edu.ucentral.relojeria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_usuario")
	private int  idUsuario;
	
	private Date fecha;
	@Column(name="fecha_entrega")
	private Date fechaEntrega;
	@OneToOne
	@JoinColumn(name="id_reloj")
	private Reloj reloj;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Reloj getReloj() {
		return reloj;
	}
	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}
	
	@Override
	public String toString() {
		return "Venta [idUsuario=" + idUsuario + ", fecha=" + fecha + ", fechaEntrega=" + fechaEntrega + ", reloj="
				+ reloj + "]";
	}

}
