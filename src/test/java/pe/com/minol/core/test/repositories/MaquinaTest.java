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

import pe.com.minol.core.entities.Maquina;

import pe.com.minol.core.repositories.MaquinaRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MinolCoreConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaquinaTest {

	@Autowired
	private MaquinaRepository maquinaRepository;
	

	@Test
	public void findAllMaquina() {
		Iterable<Maquina> maquina = maquinaRepository.findAll();
		List<Maquina> result = new ArrayList<Maquina>();
		maquina.forEach(result::add);
		Assert.notEmpty(result,"Error listado vacio");
	}
	
	@Test
	public void saveMaquina() {
		Maquina maquina = new Maquina();
		maquina.setMarca("CLI002");
		maquina.setModelo("minolta1");
		maquina.setSerie("ACCCA");
		maquinaRepository.save(maquina);
	}
}
