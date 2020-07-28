package pe.com.minol.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.minol.core.entities.Maquina;
import pe.com.minol.core.repositories.MaquinaRepository;
import pe.com.minol.core.services.MaquinaService;

@Service("maquinaService")
@Transactional
public class MaquinaServiceImpl implements MaquinaService {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Override
	@Transactional
	public List<Maquina> findAllMaquina() {
		// TODO Auto-generated method stub
		Iterable<Maquina> maquina = maquinaRepository.findAll();
		List<Maquina> result = new ArrayList<Maquina>();
		maquina.forEach(result::add);
		return result;
	}

	@Override
	public Maquina findMaquinaById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Maquina> optional = maquinaRepository.findById(id);		
		return optional.get();
	}

	@Override
	public Maquina saveOrUpdateMaquina(Maquina maquina) {
		// TODO Auto-generated method stub
		return maquinaRepository.save(maquina);
	}

	
}
