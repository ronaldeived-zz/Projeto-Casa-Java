package br.gft.cshow.controller;

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
import br.gft.cshow.repository.Casas;
import br.gft.cshow.repository.filter.CasaFilter;
import br.gft.cshow.service.CasaService;

@Controller()
@RequestMapping(value = "/cadastro-casa")
public class CasaController {
	
	public String  CASA_VIEW = "CadastrarCasa";
	
	@Autowired
	private Casas casas;
	
	@Autowired
	private CasaService casaService;
	
	@PostMapping
	public String salvarCasa(@Validated CasaM casaM, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CASA_VIEW;
		}else{
			casaService.salvar(casaM);
			attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso");
			return "redirect:/cadastro-casa";
		}
		
	}
	
	@GetMapping
	public ModelAndView listarCasas() {
		List<CasaM> listaCasa = casas.findAll();
		ModelAndView mv = new ModelAndView("CadastrarCasa");
		mv.addObject(new CasaM());
		mv.addObject("casas", listaCasa);
		return mv;
	}

	
	@GetMapping("{idCasa}")
	public ModelAndView edicao (@PathVariable ("idCasa") CasaM casaM) {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		mv.addObject(casaM);
		return mv;
	}
	@GetMapping(value = "/delete/{idCasa}")
	public String excluir(@PathVariable Long idCasa, RedirectAttributes attributes) {
		casaService.excluir(idCasa);
		attributes.addFlashAttribute("mensagem", "Casa de show excluida com sucesso");
		return "redirect:/cadastro-casa";
	}
	
	
}
