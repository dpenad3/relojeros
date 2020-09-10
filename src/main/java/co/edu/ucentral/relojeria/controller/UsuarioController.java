package co.edu.ucentral.relojeria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editarUsuario(Authentication auth, HttpSession sesion, Model model) {
		String userName = auth.getName();
		model.addAttribute("usuario", new Usuario());
		sesion.getAttribute("usuario");
		Usuario usuario = userService.bucarPorUserName(userName);
		usuario.setPassword(null);
		sesion.setAttribute("usuario", usuario);
		model.addAttribute("usuario", usuario);
		return "gestion/editar";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes, Authentication auth, HttpSession sesion) {
		if(result.hasErrors())
		{
			return "gestion/editar";
		}
		usuario.setEstatus(1);
		userService.modificar(usuario);
		attributes.addAttribute("msg", "Registro modificado");
		return "redirect:/catalogo";
	}
	
}
