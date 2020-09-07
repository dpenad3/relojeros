package co.edu.ucentral.relojeria.JPA;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.repository.UsuarioRepository;
import co.edu.ucentral.relojeria.service.UsuarioService;

@Service
@Primary
public class UsuarioServiceJPA implements UsuarioService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public void registro(Usuario user) {
		repo.save(user);
	}
		

	@Override
	public void modificar(Usuario user) {	
		repo.save(user);
	}

	@Override
	public void login(int cedula, String contrasenia) {
		// TODO Auto-generated method stub
	}


	@Override
	public Usuario buscarUsaurioPorId(int idUsuario) {
		Optional<Usuario> optional= repo.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	@Override
	public Usuario bucarPorUserName(String username) {
		return repo.findByUsername(username);
	}

}
