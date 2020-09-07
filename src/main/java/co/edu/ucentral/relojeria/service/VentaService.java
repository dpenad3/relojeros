package co.edu.ucentral.relojeria.service;

import java.util.List;

import co.edu.ucentral.relojeria.model.Venta;

public interface VentaService {
	
	public void registro(Venta venta);
	public void eliminar(int idVenta);
	public Venta buscarPorId(int idVenta);
	public List<Venta> listar(int idUsuario);

}
