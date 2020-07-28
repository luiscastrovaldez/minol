package pe.com.minol.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.minol.core.entities.Client;
import pe.com.minol.core.entities.Maquina;
import pe.com.minol.core.entities.Tecnico;
import pe.com.minol.core.services.ClientService;
import pe.com.minol.core.services.MaquinaService;
import pe.com.minol.core.services.TecnicoService;
import pe.com.minol.core.services.MinolService;

@Service("minolService")
@Transactional
public class MinolServiceImpl implements MinolService {

	@Autowired
	private ClientService clientService;

	@Override
	@Transactional
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return clientService.findAllClients();
	}

	@Override
	public Client findClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientService.findClientById(id);
	}

	@Override
	public Client saveOrUpdateClient(Client client) {
		// TODO Auto-generated method stub
		return clientService.saveOrUpdateClient(client);
	}
	
	/*
	 * 
	*/	
	
	@Autowired
	private MaquinaService maquinaService;

	@Override
	@Transactional
	public List<Maquina> findAllMaquina() {
		// TODO Auto-generated method stub
		return maquinaService.findAllMaquina();
	}

	@Override
	public Maquina findMaquinaById(Integer id) {
		// TODO Auto-generated method stub
		return maquinaService.findMaquinaById(id);
	}

	@Override
	public Maquina saveOrUpdateMaquina(Maquina maquina) {
		// TODO Auto-generated method stub
		return maquinaService.saveOrUpdateMaquina(maquina);
	}
	
	/*
	 * 
	*/	
	@Autowired
	private TecnicoService tecnicoService;

	@Override
	@Transactional
	public List<Tecnico> findAllTecnico() {
		// TODO Auto-generated method stub
		return tecnicoService.findAllTecnico();
	}

	@Override
	public Tecnico findTecnicoById(Integer id) {
		// TODO Auto-generated method stub
		return tecnicoService.findTecnicoById(id);
	}

	@Override
	public Tecnico saveOrUpdateTecnico(Tecnico tecnico) {
		// TODO Auto-generated method stub
		return tecnicoService.saveOrUpdateTecnico(tecnico);
	}	
	
}
