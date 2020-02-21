package br.gft.cshow.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import br.gft.cshow.repository.Casas;
import br.gft.cshow.repository.Eventos;

@Controller
@RequestMapping("/inicio")
public class InicioController {
	
	public static String HOME_VIEW = "Inicio";
	
	private Eventos eventos;
	private Casas casas;
	
	
	@RequestMapping()
	public String inicio() {
		return HOME_VIEW;
	}
	
	
	
	
}
