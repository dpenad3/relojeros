package co.edu.ucentral.relojeria.service;

import java.util.List;

import co.edu.ucentral.relojeria.model.Usuario;

public interface AdminService {
	
	public List<Usuario> lista();
	public void cambiarEstado();

}
