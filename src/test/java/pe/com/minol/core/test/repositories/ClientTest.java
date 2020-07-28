package pe.com.minol.core.test.repositories;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import pe.com.minol.core.conf.MinolCoreConfig;
import pe.com.minol.core.entities.Client;
import pe.com.minol.core.repositories.ClientRepository;
import pe.com.minol.core.repositories.MaquinaRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MinolCoreConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientTest {

	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void findAllClients() {
		Iterable<Client> clients = clientRepository.findAll();
		List<Client> result = new ArrayList<Client>();
		clients.forEach(result::add);
		Assert.notEmpty(result,"Error listado vacio");
	}
	
	@Test
	public void saveClient() {
		Client client = new Client();
		client.setClientCode("CLI002");
		client.setClientName("minolta1");
		clientRepository.save(client);
	}
	
}
