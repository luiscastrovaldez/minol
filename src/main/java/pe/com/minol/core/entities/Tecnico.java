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
@Table(name = "tecnico")
public class Tecnico implements Serializable {
	
	private static final long serialVersionUID = -7666693220047661869L;
	
	private Integer idtecnico;
	private String nombre;
	private String apellido;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtecnico", unique = true, nullable = false, length = 20 )
	public Integer getIdtecnico() {
		return idtecnico;
	}
	public void setIdtecnico(Integer idtecnico) {
		this.idtecnico = idtecnico;
	}	

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido", unique = true, nullable = false, length = 45)	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Transient
	public boolean isNew() {
		return (this.idtecnico == null);
	}
	
}
