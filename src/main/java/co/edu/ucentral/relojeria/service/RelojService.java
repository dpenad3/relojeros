package co.edu.ucentral.relojeria.service;

import java.util.List;

import org.springframework.data.domain.Example;

import co.edu.ucentral.relojeria.model.Reloj;

public interface RelojService {
	
	public void registro(Reloj reloj);
	public void modificar(Reloj reloj);
	public List<Reloj> mostrar();
	public Reloj buscarId(int id);
	public void eliminar(int id);
	public List<Reloj> buscarByExample(Example<Reloj> example);

}
