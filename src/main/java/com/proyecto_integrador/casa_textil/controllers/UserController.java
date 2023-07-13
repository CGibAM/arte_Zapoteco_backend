package com.proyecto_integrador.casa_textil.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_integrador.casa_textil.entities.Usuario;
import com.proyecto_integrador.casa_textil.service.UserService;

@CrossOrigin(origins ="http://127.0.0.1:5505")
@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(consumes = "application/json")
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return userService.postUsuario(usuario);
	}
	
	//Método PUT para modificar un producto
		@PutMapping (path="{userId}") //path para agregarle el id al endpoint
		
		public Usuario updateUsuario(@PathVariable("userId") Long id, 
				@RequestParam(required = false) String name,      
				@RequestParam(required = false) String phoneNumber, 
				@RequestParam(required = false) String email, 
				@RequestParam(required = false) String address,
				@RequestParam(required = false) Integer discount,
				@RequestParam(required = false) Boolean newCostumer,
				@RequestParam(required = false) String password) {
			
			return userService.actualizarUsuario(id, name, phoneNumber, email, address, discount, newCostumer, password);
			
		}//updateProducto
	
	
	@DeleteMapping (path = "{userId}")
	public Usuario deleteUsuario(@PathVariable ("userId") Long id) {
		
		return userService.deleteUsuario(id);
		
	}
	
	
	
@GetMapping
public List<Usuario> getTodosLosUsuarios(){
		return userService.leerTodosLosUsuarios();
		
	}

}


