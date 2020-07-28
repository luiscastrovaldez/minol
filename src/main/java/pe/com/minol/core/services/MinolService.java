package pe.com.minol.core.services;

import java.util.List;

import pe.com.minol.core.entities.Client;
import pe.com.minol.core.entities.Maquina;
import pe.com.minol.core.entities.Tecnico;
import pe.com.minol.core.entities.Repuesto;

public interface MinolService {

	List<Client> findAllClients();
	Client findClientById(Integer id);
	Client saveOrUpdateClient(Client client);
	
	/*
	 * 
	*/
	
	List<Maquina> findAllMaquina();
	Maquina findMaquinaById(Integer id);	
	Maquina saveOrUpdateMaquina(Maquina maquina);
	
	/*
	 * 
	*/
	List<Tecnico> findAllTecnico();
	Tecnico findTecnicoById(Integer id);
	Tecnico saveOrUpdateTecnico(Tecnico tecnico);
	
	/*
	 * 
	*/
	List<Repuesto> findAllRepuesto();
	Repuesto findRepuestoById(Integer id);
	Repuesto saveOrUpdateRepuesto(Repuesto repuesto);
}
