package com.proyecto_integrador.casa_textil.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_integrador.casa_textil.entities.Usuario;
import com.proyecto_integrador.casa_textil.service.UserService;
import com.proyecto_integrador.casa_textil.utils.LoginRequest;
import com.proyecto_integrador.casa_textil.utils.UsuarioNoEncontrado;

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
	
	@PostMapping(path="/login", consumes = "application/json")
	public ResponseEntity<String> loginUsuario(@RequestBody LoginRequest loginrequest) {
		try {
			Usuario usuario = userService.validateEmail(loginrequest.getEmail());
			if(usuario.getPassword().equals(loginrequest.getPassword())) {
				Integer userId = usuario.getId();
				return ResponseEntity.ok().body(userId.toString());
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
			}
		}catch(UsuarioNoEncontrado e){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
		}
	}
	
}
