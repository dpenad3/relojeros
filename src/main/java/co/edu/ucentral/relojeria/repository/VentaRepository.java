package co.edu.ucentral.relojeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.relojeria.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
	
	public List<Venta>findByIdUsuario(int idUsuario);
	
}
