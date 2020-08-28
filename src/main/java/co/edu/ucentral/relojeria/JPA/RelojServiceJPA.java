package co.edu.ucentral.relojeria.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.ucentral.relojeria.model.Reloj;
import co.edu.ucentral.relojeria.repository.RelojRepository;
import co.edu.ucentral.relojeria.service.RelojService;


@Service
@Primary
public class RelojServiceJPA implements RelojService{

	@Autowired
	private RelojRepository repo;
	
	@Override
	public void registro(Reloj reloj) {
		repo.save(reloj);
	}

	@Override
	public void modificar(Reloj reloj) {
		repo.save(reloj);
	}

	@Override
	public List<Reloj> mostrar() {
		return repo.findAll();
	}

	@Override
	public Reloj buscarId(int id) {
		Optional<Reloj> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

}
