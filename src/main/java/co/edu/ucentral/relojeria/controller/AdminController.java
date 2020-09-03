package co.edu.ucentral.relojeria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.AdminService;
import co.edu.ucentral.relojeria.service.UsuarioService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private UsuarioService userService;
	
	@RequestMapping(value= "/lista", method=RequestMethod.GET)
	public String mostrarUsuarios(Model model) {
		model.addAttribute("usuarios", adminservice.lista());
		return "admin/listado";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") Integer idUsuario, RedirectAttributes attributes) {
		adminservice.eliminarUsuario(idUsuario);
		attributes.addAttribute("msg", "Usuario eliminado");
		return "redirect:/admin/lista";
	}
	
	@RequestMapping(value="/inactivar/{id}", method=RequestMethod.GET)
	public String inactivarUsuario(@PathVariable("id") Integer idUsuario, RedirectAttributes attributes) {
		Usuario user = userService.buscarUsaurioPorId(idUsuario);
		user.setEstatus(2);
		userService.modificar(user);
		return "redirect:/admin/lista";
	}
	
	@RequestMapping(value="/activar/{id}", method=RequestMethod.GET)
	public String activarUsuario(@PathVariable("id") Integer idUsuario, RedirectAttributes attributes) {
		Usuario user = userService.buscarUsaurioPorId(idUsuario);
		user.setEstatus(1);
		userService.modificar(user);
		return "redirect:/admin/lista";
	}
}
