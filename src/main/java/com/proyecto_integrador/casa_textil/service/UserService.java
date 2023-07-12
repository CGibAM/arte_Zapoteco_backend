package com.proyecto_integrador.casa_textil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_integrador.casa_textil.entities.Cart;
import com.proyecto_integrador.casa_textil.entities.Usuario;
import com.proyecto_integrador.casa_textil.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private Cart cart;
	private EntityManager entityManager;
	
	
	@Autowired
	public UserService (UserRepository userRepository, Cart cart,EntityManager entityManager) {
		this.userRepository = userRepository;
		this.cart = cart;
		this.entityManager = entityManager;
	}
	
	@Transactional
	public Usuario postUsuario(Usuario usuario) {
		usuario.setId(null);
		Cart mergedCart = entityManager.merge(cart);
		usuario.setCartIdCart(mergedCart);
		return userRepository.save(usuario);
	}

}
