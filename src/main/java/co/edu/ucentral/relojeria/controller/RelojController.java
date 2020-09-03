package co.edu.ucentral.relojeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.relojeria.model.Categoria;
import co.edu.ucentral.relojeria.model.Reloj;
import co.edu.ucentral.relojeria.service.CategoriaService;
import co.edu.ucentral.relojeria.service.RelojService;

@Controller
@RequestMapping("/relojes")
public class RelojController {

	@Autowired
	private RelojService relojservice;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crearReloj(Model model) {
		List<Categoria> lista = categoriaService.listarCategorias();
		model.addAttribute("categorias", lista);
		model.addAttribute("reloj", new Reloj());
		return "relojes/formReloj";
	}
	
	@RequestMapping(value= "/listado", method=RequestMethod.GET)
	public String listaRelojes(Model model) {
		model.addAttribute("relojes", relojservice.mostrar());
		return "relojes/listado";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Reloj reloj, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors())
		{
			return "relojes/formReloj";
		}
		relojservice.registro(reloj);
		attributes.addAttribute("msg", "Registro guardado");
		return "redirect:/relojes/listado";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editarReloj(@PathVariable("id") int id, Model model) {
		Reloj reloj = relojservice.buscarId(id);
		model.addAttribute("reloj", reloj);
		return "relojes/formReloj";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String eliminarReloj(@PathVariable("id") int id, Model model) {
		relojservice.eliminar(id);
		return "redirect:/relojes/listado";
	}
	
}
