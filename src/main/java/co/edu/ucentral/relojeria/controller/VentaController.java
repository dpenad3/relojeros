package co.edu.ucentral.relojeria.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.ucentral.relojeria.model.Reloj;
import co.edu.ucentral.relojeria.model.Usuario;
import co.edu.ucentral.relojeria.model.Venta;
import co.edu.ucentral.relojeria.service.RelojService;
import co.edu.ucentral.relojeria.service.UsuarioService;
import co.edu.ucentral.relojeria.service.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private RelojService relojservice;
	
	@RequestMapping(value="/comprar/{id}", method=RequestMethod.GET)
	public String comprar(Authentication auth, HttpSession sesion, @PathVariable("id") int idReloj) {
		String userName = auth.getName();
		Usuario usuario = userService.bucarPorUserName(userName);
		
		Venta venta = new Venta();
		venta.setIdUsuario(usuario.getId());;
		Reloj reloj = relojservice.buscarId(idReloj);
		venta.setReloj(reloj);
		venta.setFecha(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(venta.getFecha());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		venta.setFechaEntrega(calendar.getTime());
		
		ventaService.registro(venta);
		
		return "redirect:/venta/compras";
	}
	
	@RequestMapping(value= "/compras", method=RequestMethod.GET)
	public String listaRelojes(Model model, Authentication auth, HttpSession sesion) {
		
		String userName = auth.getName();
		Usuario usuario = userService.bucarPorUserName(userName);
		model.addAttribute("compras", ventaService.listar(usuario.getId()));
		return "compras/listado";
	}

}
