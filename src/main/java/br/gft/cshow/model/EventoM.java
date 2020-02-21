package br.gft.cshow.model;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class EventoM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvento;
	
	@NotEmpty(message = "Evento deve ser preenchido!")
	@Size(max = 60, message = "O evento não pode conter mais que 60 caracteres")
	private String nomeEvento;
	
	@NotNull(message = "Capacidade deve ser preenchido!")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9999999.99")
	private BigInteger capacidade;
	
	@NotNull(message = "Data deve ser preenchida")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dtEvento;
	
	@NotNull(message = "Valor deve ser preenchido!")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9999999.99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorIngresso;
	
	@ManyToOne
	private CasaM casaM;
	
	
	@OneToMany(mappedBy = "eventoM", cascade = CascadeType.ALL)
	private List<CarrinhoM> carrinhoM;
	
	@Enumerated(EnumType.STRING)
	private GeneroEvento generoEvento;

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public BigInteger getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(BigInteger capacidade) {
		this.capacidade = capacidade;
	}

	public Date getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(Date dtEvento) {
		this.dtEvento = dtEvento;
	}

	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(BigDecimal valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	
	public GeneroEvento getGeneroEvento() {
		return generoEvento;
	}

	public void setGeneroEvento(GeneroEvento generoEvento) {
		this.generoEvento = generoEvento;
	}

	public CasaM getCasaM() {
		return casaM;
	}

	public void setCasaM(CasaM casaM) {
		this.casaM = casaM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
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
		EventoM other = (EventoM) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}
	
	
}
