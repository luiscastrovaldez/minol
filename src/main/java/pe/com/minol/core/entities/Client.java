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
@Table(name = "client")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7666693220047661869L;
	private Integer clientId;		
	private String clientCode;
	private String clientName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 20)
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	
	@Column(name = "CODE", unique = true, nullable = false, length = 11)
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
	@Column(name = "NAME", unique = true, nullable = false, length = 250)
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Transient
	public boolean isNew() {
		return (this.clientId == null);
	}
	
	
	

}
