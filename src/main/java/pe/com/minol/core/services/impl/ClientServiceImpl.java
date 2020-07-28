package pe.com.minol.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.minol.core.entities.Client;
import pe.com.minol.core.repositories.ClientRepository;
import pe.com.minol.core.services.ClientService;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	@Transactional
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		Iterable<Client> clients = clientRepository.findAll();
		List<Client> result = new ArrayList<Client>();
		clients.forEach(result::add);
		return result;
	}

	@Override
	public Client findClientById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Client> optional = clientRepository.findById(id);		
		return optional.get();
	}

	@Override
	public Client saveOrUpdateClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	
}
