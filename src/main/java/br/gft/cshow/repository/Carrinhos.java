package br.gft.cshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gft.cshow.model.CarrinhoM;

public interface Carrinhos extends JpaRepository<CarrinhoM, Long> {

}
