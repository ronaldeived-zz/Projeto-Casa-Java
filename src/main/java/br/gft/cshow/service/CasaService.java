package br.gft.cshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gft.cshow.model.CasaM;
import br.gft.cshow.repository.Casas;
import br.gft.cshow.repository.filter.CasaFilter;


@Service
public class CasaService {
	
	@Autowired
	private Casas casas;
	
	public void salvar(CasaM casaM) {
		casas.save(casaM);
	}
	
	public List<CasaM> filtrar(CasaFilter filtroCasa){
		String nomecs = filtroCasa.getNomecs() == null ? "" : filtroCasa.getNomecs();
		return casas.findByNomecsContaining(nomecs);
		
	}
	
	public void excluir(Long idCasa) {
		casas.deleteById(idCasa);
	}
}
