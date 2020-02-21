package br.gft.cshow.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gft.cshow.model.CasaM;
import br.gft.cshow.model.EventoM;
import br.gft.cshow.model.GeneroEvento;
import br.gft.cshow.repository.Casas;
import br.gft.cshow.repository.Eventos;
import br.gft.cshow.service.EventoService;

@Controller
@RequestMapping(value = "/cadastro-eventos")
public class EventoController {
	
	@Autowired
	private Eventos eventos;
	
	@Autowired
	private Casas casas;
	
	@Autowired
	private EventoService eventoService;
	
	public static String EVENTO_VIEW = "CadastrarEventos";

	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject(new EventoM());
		mv.addObject("todosGenerosEvento", GeneroEvento.values());
		return mv;
	}
	
	@PostMapping
	public String salvarEvento(@Validated EventoM eventoM, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return EVENTO_VIEW;
		}
		
		try {
			eventoService.salvar(eventoM);
			attributes.addFlashAttribute("mensagem", "Evento Salvo com sucesso");
			return "redirect:/cadastro-eventos";			
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dtEvento", null,  e.getMessage());
			return EVENTO_VIEW;
		}
	}
	
	@GetMapping
	public ModelAndView listarEventos() {
		List<EventoM> listaEventos = eventos.findAll();
		List<CasaM> listaCasa = casas.findAll();
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject(new EventoM());
		mv.addObject("casas", listaCasa);
		mv.addObject("eventos", listaEventos);
		return mv;
	}
	
	@RequestMapping("{idEvento}")
	public ModelAndView edicao (@PathVariable ("idEvento") EventoM eventoM) {
		List<CasaM> listaCasa = casas.findAll();
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject(eventoM);
		mv.addObject("casas", listaCasa);
		return mv;
	}
	
	@GetMapping(value = "/delete/{idEvento}")
	public String excluir (@PathVariable Long idEvento, RedirectAttributes attributes) {
		eventoService.excluir(idEvento);
		attributes.addFlashAttribute("mensagem", "Evento excluido com sucesso");
		return "redirect:/cadastro-eventos";
	}
	
	@ModelAttribute("todosGenerosEvento")
	public List<GeneroEvento> todosGenerosEvento(){
		return Arrays.asList(GeneroEvento.values());
	}
}
