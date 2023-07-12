package com.proyecto_integrador.casa_textil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_integrador.casa_textil.entities.Usuario;
 
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
}
