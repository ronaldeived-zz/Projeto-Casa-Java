package br.gft.cshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.gft.cshow.model.CarrinhoM;
import br.gft.cshow.model.CompraM;
import br.gft.cshow.repository.Compras;

@Controller
public class CompraController {

	@Autowired
	private Compras compras;
	
	
	public String compra(CompraM compraM) {
	
		
		return "redirect:/historico-de-compras";
	}
	
}
