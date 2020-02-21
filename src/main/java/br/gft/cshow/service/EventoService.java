package br.gft.cshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.gft.cshow.model.EventoM;
import br.gft.cshow.repository.Eventos;

@Service
public class EventoService {
	
	@Autowired
	private Eventos eventos;
	
	public void salvar(EventoM eventoM) {
		try {
			eventos.save(eventoM);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public void excluir (Long idEvento) {
		eventos.deleteById(idEvento);
	}
	
}
