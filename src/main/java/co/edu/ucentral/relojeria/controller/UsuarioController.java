package co.edu.ucentral.relojeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editarUsuario(@PathVariable("id") int id, Model model) {
		Usuario user = userService.buscarUsaurioPorId(id);
		model.addAttribute("usuario", user);
		return "relojes/formReloj";
	}
	
	
}
