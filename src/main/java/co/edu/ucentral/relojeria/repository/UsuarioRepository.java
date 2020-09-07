package co.edu.ucentral.relojeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.relojeria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);
}
