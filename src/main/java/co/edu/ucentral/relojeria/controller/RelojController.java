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
import co.edu.ucentral.relojeria.model.Reloj;
import co.edu.ucentral.relojeria.service.RelojService;

@Controller
@RequestMapping("/relojes")
public class RelojController {

	@Autowired
	private RelojService relojservice;
	
	
	@RequestMapping(value= "/catalogo", method=RequestMethod.GET)
	public String mostrarRelojes(Model model) {
		List<Reloj> lista = relojservice.mostrar();
		model.addAttribute("relojes", lista);
		return "relojes/catalogo";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crearReloj() {
		return "relojes/formReloj";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Reloj reloj, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors())
		{
			return "relojes/formEmpleo";
		}
		relojservice.registro(reloj);
		attributes.addAttribute("msg", "Registro guardado");
		return "redirect:/relojes/listado";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editarReloj(@PathVariable("id") int id, Model model) {
		Reloj empleo = relojservice.buscarId(id);
		model.addAttribute("reloj", empleo);
		return "relojes/formEmpleo";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String eliminarReloj(@PathVariable("id") int id, Model model) {
		relojservice.elimiar(id);
		return "relojes/listado";
	}
}
