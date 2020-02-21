package br.gft.cshow.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class CarrinhoM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinho;
	
	private Integer quantidade;

	@ManyToOne
	private EventoM eventoM;
	
	@OneToMany(mappedBy = "carrinhoM", orphanRemoval = true)
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
	private List<HistoricoM> historicoM;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCarrinho == null) ? 0 : idCarrinho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoM other = (CarrinhoM) obj;
		if (idCarrinho == null) {
			if (other.idCarrinho != null)
				return false;
		} else if (!idCarrinho.equals(other.idCarrinho))
			return false;
		return true;
	}

	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public EventoM getEventoM() {
		return eventoM;
	}

	public void setEventoM(EventoM eventoM) {
		this.eventoM = eventoM;
	}

}
