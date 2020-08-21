package co.edu.ucentral.relojeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "gestion/registro.html";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Usuario usuario) {
		userService.registro(usuario);
		return "redirect:index";
	}
	
	
}
