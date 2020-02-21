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
import br.gft.cshow.model.HistoricoM;
import br.gft.cshow.repository.Carrinhos;
import br.gft.cshow.repository.Historicos;


@Controller
@RequestMapping("/historico-de-compras")
public class HistoricoController {

	@Autowired
	private Historicos historicos;
	
	@Autowired
	private Carrinhos carrinhos;
	
	private static String VIEW_COMPRAS = "HistoricoCompras";
	
	@RequestMapping
	public ModelAndView compras() {
		ModelAndView mv = new ModelAndView(VIEW_COMPRAS);
		mv.addObject(new HistoricoM());
		return mv;
	}
	
	@GetMapping("{idCarrinho}")
	public ModelAndView historico(HistoricoM historicoM, Integer quantidade, @PathVariable("idCarrinho")Long idCarrinho) {
		CarrinhoM carrinhoM = carrinhos.findById(idCarrinho).get();
		carrinhoM.setQuantidade(quantidade);
		ModelAndView mv = new ModelAndView(VIEW_COMPRAS);
		mv.addObject("compras", historicoM);
		historicoM.setIdHistorico(idCarrinho);
		historicos.save(historicoM);
		return mv;
	}
}
