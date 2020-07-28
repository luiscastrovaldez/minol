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
@Table(name = "repuesto")
public class Repuesto implements Serializable {
	
	private static final long serialVersionUID = -7666693220047661869L;
	
	private Integer idrepuesto;
	private String descrip;
	private String cantidad;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idrepuesto", unique = true, nullable = false, length = 20 )
	public Integer getIdrepuesto() {
		return idrepuesto;
	}
	public void setIdrepuesto(Integer idrepuesto) {
		this.idrepuesto = idrepuesto;
	}	

	@Column(name = "descrip", unique = true, nullable = false, length = 200)
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	@Column(name = "cantidad", unique = true, nullable = false, length = 45)	
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	@Transient
	public boolean isNew() {
		return (this.idrepuesto == null);
	}
	
}
