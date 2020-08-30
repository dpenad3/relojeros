package co.edu.ucentral.relojeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.relojeria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
