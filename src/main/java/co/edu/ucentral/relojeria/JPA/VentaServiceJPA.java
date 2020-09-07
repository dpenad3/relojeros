package co.edu.ucentral.relojeria.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.ucentral.relojeria.model.Venta;
import co.edu.ucentral.relojeria.repository.VentaRepository;
import co.edu.ucentral.relojeria.service.VentaService;

@Service
@Primary
public class VentaServiceJPA implements VentaService{

	
	@Autowired
	private VentaRepository repo;
	
	@Override
	public void registro(Venta venta) {
		repo.save(venta);
	}

	@Override
	public void eliminar(int idVenta) {
		repo.deleteById(idVenta);
	}

	@Override
	public Venta buscarPorId(int idVenta) {
		Optional<Venta> optional = repo.findById(idVenta);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public List<Venta> listar(int idUsuario) {
		return repo.findByIdUsuario(idUsuario);
	}
}
