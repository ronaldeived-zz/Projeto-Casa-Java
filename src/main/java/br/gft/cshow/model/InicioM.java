package br.gft.cshow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InicioM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInicio;
	
}
