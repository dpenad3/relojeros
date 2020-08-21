package co.edu.ucentral.relojeria.JPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.repository.AdminRepository;
import co.edu.ucentral.relojeria.service.AdminService;

@Service
@Primary
public class AdminServiceJPA implements AdminService{

	@Autowired
	private AdminRepository repo;
	
	@Override
	public List<Usuario> lista() {
		System.out.println("BOBOSSSS");
		System.out.println(repo.findAll());
		return repo.findAll();
	}

	@Override
	public void cambiarEstado() {
		// TODO Auto-generated method stub
	}

}
