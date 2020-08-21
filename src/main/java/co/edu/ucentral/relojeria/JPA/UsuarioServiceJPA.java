package co.edu.ucentral.relojeria.JPA;

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
		user.setEstado(3);
		user.setRol(1);
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

}
