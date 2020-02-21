package br.gft.cshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gft.cshow.model.HistoricoM;

public interface Historicos extends JpaRepository<HistoricoM, Long> {

}
