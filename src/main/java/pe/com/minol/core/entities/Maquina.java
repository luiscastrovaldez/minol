package pe.com.minol.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "maquina")
public class Maquina implements Serializable {
	
	private static final long serialVersionUID = -7666693220047661869L;
	
	private Integer idMaquina;
	private String marca;
	private String modelo;
	private String serie;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmaquina", unique = true, nullable = false, length = 20 )
	
	public Integer getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
	}

	@Column(name = "marca", unique = true, nullable = false, length = 45)
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Column(name = "modelo", unique = true, nullable = false, length = 45)	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Column(name = "serie", unique = true, nullable = false, length = 45)	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	@Transient
	public boolean isNew() {
		return (this.idMaquina == null);
	}
	
}
