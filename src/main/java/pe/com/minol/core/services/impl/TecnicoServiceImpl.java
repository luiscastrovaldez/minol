package pe.com.minol.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.minol.core.entities.Tecnico;
import pe.com.minol.core.repositories.TecnicoRepository;
import pe.com.minol.core.services.TecnicoService;

@Service("tecnicoService")
@Transactional
public class TecnicoServiceImpl implements TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Override
	@Transactional
	public List<Tecnico> findAllTecnico() {
		// TODO Auto-generated method stub
		Iterable<Tecnico> tecnico = tecnicoRepository.findAll();
		List<Tecnico> result = new ArrayList<Tecnico>();
		tecnico.forEach(result::add);
		return result;
	}

	@Override
	public Tecnico findTecnicoById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Tecnico> optional = tecnicoRepository.findById(id);		
		return optional.get();
	}

	@Override
	public Tecnico saveOrUpdateTecnico(Tecnico tecnico) {
		// TODO Auto-generated method stub
		return tecnicoRepository.save(tecnico);
	}

	
}
