package br.gft.cshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gft.cshow.model.Usuario;
import br.gft.cshow.repository.Usuarios;

@Controller
public class UsuarioController {

	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping(value = "/")
	public String entrar() {
		return "Login";
	}
	@PostMapping(value = "/cadastrar-usuario")
	public ModelAndView novoCadastro(@Validated Usuario usuario) {
		ModelAndView mv = new ModelAndView("Login");
		mv.addObject(new Usuario());
		usuarios.save(usuario);
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		
		return "Login";
	}
}
