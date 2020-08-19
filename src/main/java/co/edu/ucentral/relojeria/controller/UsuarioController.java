package co.edu.ucentral.relojeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registro(Usuario user) {
		userService.registro(user);
		return "gestion/registro.html";
	}
}
