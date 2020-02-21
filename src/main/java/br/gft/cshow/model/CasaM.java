package br.gft.cshow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;


@Entity
public class CasaM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCasa;
	
	@NotEmpty(message = "Endereço não pode ser vazio")
	@Size(max = 60, message = "O endereço não pode conter mais que 60 caracteres")
	private String endereco;
	
	@NotEmpty(message = "Casa de Show não pode ser vazio")
	@Size(max = 60, message = "Nome da Casa de show não pode conter mais que 60 caracteres")
	private String nomecs;
	
	@OneToMany(mappedBy = "casaM" , cascade = CascadeType.ALL)//, orphanRemoval=true
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<EventoM> eventosM;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCasa == null) ? 0 : idCasa.hashCode());
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
		CasaM other = (CasaM) obj;
		if (idCasa == null) {
			if (other.idCasa != null)
				return false;
		} else if (!idCasa.equals(other.idCasa))
			return false;
		return true;
	}
	
	public List<EventoM> getEventoM() {
		return eventosM;
	}

	public void setEventoM(List<EventoM> eventoM) {
		this.eventosM = eventoM;
	}
	
	public Long getIdCasa() {
		return idCasa;
	}

	public void setIdCasa(Long idCasa) {
		this.idCasa = idCasa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomecs() {
		return nomecs;
	}

	public void setNomecs(String nomecs) {
		this.nomecs = nomecs;
	}

	

}
