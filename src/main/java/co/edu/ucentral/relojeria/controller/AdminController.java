package co.edu.ucentral.relojeria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import co.edu.ucentral.relojeria.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
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
}
