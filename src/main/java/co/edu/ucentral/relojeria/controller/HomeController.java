package co.edu.ucentral.relojeria.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.relojeria.model.Perfil;
import co.edu.ucentral.relojeria.model.Reloj;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.service.CategoriaService;
import co.edu.ucentral.relojeria.service.RelojService;
import co.edu.ucentral.relojeria.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private RelojService relojservice;
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@GetMapping("/")
	public String mostrarHome() {
		return "index";
	}
	
	@RequestMapping(value= "/catalogo", method=RequestMethod.GET)
	public String mostrarRelojes(Model model) {
		model.addAttribute("relojes", relojservice.mostrar());
		return "relojes/catalogo";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalleReloj(@PathVariable("id") int id, Model model) {
		Reloj reloj = relojservice.buscarId(id);
		model.addAttribute("reloj", reloj);
		return "relojes/detalle";
	}
	
	@GetMapping("/search")
	public String listarRelojes(@ModelAttribute("search") Reloj reloj, Model model) {
		System.out.println("BUSCANDO POR: " + reloj);
		Example<Reloj> example = Example.of(reloj);
		model.addAttribute("relojes", relojservice.buscarByExample(example));
		return "relojes/catalogo";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String registro(Usuario usuario) {
		return "gestion/registro";
	}
	
	@PostMapping("/signup")
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		/*System.out.println("SI LLEGA");
		String pwdPlano = usuario.getContrasena();
		String pwdEncrip = passwordEncoder.encode(pwdPlano);
		usuario.setContrasena(pwdEncrip);*/
		usuario.setEstatus(1);
		Perfil perfil = new Perfil();
		perfil.setId(1);
		if(result.hasErrors())
		{
			return "gestion/registro";
		}
		userService.registro(usuario);
		attributes.addFlashAttribute("msg", "Registro exitoso");
		return "redirect:relojes/catalogo";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String sesion() {
		return "gestion/sesion";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/catalogo";
	}

	
	@ModelAttribute
	public void setGenericos(Model model) {
		Reloj relojSearch = new Reloj();		
		model.addAttribute("search", relojSearch);
		model.addAttribute("categorias", categoriaService.listarCategorias());
		model.addAttribute("relojes", relojservice.mostrar());
	}

}
