package co.edu.ucentral.relojeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@RequestMapping(value= "/lista", method=RequestMethod.GET)
	public String mostrarUsuarios(Model model) {
		List<Usuario> lista = adminservice.lista();
		model.addAttribute("usuarios", lista);
		return "admin/listado";
	}
}
