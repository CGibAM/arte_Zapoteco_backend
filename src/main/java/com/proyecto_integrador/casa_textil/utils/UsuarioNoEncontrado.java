package com.proyecto_integrador.casa_textil.utils;

public class UsuarioNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontrado(String mensaje) {
		super(mensaje);
	}
}
