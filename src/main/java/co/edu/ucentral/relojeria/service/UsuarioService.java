package co.edu.ucentral.relojeria.service;

import co.edu.ucentral.relojeria.model.Usuario;

public interface UsuarioService {
	
	public void registro(Usuario user);
	public void modificar(Usuario user);
	public void login(int cedula, String contrasenia);
	
}
