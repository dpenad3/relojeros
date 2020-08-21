package co.edu.ucentral.relojeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.relojeria.model.Reloj;

public interface RelojRepository extends JpaRepository<Reloj, Integer> {

}