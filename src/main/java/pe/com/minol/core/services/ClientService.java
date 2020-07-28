package pe.com.minol.core.services;

import java.util.List;

import pe.com.minol.core.entities.Client;

public interface ClientService {

	List<Client> findAllClients();
	Client findClientById(Integer id);
	Client saveOrUpdateClient(Client client);
	
}
