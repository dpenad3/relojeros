package co.edu.ucentral.relojeria.service;

import java.util.List;

import co.edu.ucentral.relojeria.model.Categoria;


public interface CategoriaService {

	public List<Categoria> listarCategorias();
	public Categoria buscarPorId(int idCategoria);
	public void guardar(Categoria categoria);
	public void borrar(Integer idCategoria);
}
