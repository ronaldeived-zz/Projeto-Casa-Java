package br.gft.cshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gft.cshow.model.CasaM;

public interface Casas extends JpaRepository<CasaM, Long> {
	
	public List<CasaM>  findByNomecsContaining(String nomecs);
	
		
}
