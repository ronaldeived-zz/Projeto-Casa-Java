package br.gft.cshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gft.cshow.model.EventoM;

public interface Eventos extends JpaRepository<EventoM, Long>{

}
