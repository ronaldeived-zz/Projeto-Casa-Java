package br.gft.cshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gft.cshow.model.CarrinhoM;
import br.gft.cshow.model.CasaM;
import br.gft.cshow.model.EventoM;
import br.gft.cshow.repository.Carrinhos;
import br.gft.cshow.repository.Casas;
import br.gft.cshow.repository.Eventos;

@Controller
@RequestMapping("/evento/carrinho")
public class CarrinhoController {
	
	@Autowired
	private Casas casas;
	
	@Autowired
	private Eventos eventos;
	
	@Autowired
	private Carrinhos carrinhos;
	
	private static String VIEW_CARRINHO = "Carrinho";
	
	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(VIEW_CARRINHO);
		mv.addObject(new CarrinhoM());
		return mv;
	}
	
	@GetMapping("{idEvento}")
	public ModelAndView carrinho(CarrinhoM carrinhoM, Integer quantidade, @PathVariable("idEvento")Long idEvento) {
		EventoM eventoM = eventos.findById(idEvento).get();
		ModelAndView mv = new ModelAndView(VIEW_CARRINHO);
		mv.addObject("carrinhos", carrinhoM);
		carrinhoM.setEventoM(eventoM);
		carrinhos.save(carrinhoM);
		return mv;
	}
}
