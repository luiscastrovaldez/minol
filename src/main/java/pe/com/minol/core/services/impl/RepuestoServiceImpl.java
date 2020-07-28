package pe.com.minol.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.minol.core.entities.Repuesto;
import pe.com.minol.core.repositories.RepuestoRepository;
import pe.com.minol.core.services.RepuestoService;

@Service("repuestoService")
@Transactional
public class RepuestoServiceImpl implements RepuestoService {

	@Autowired
	private RepuestoRepository respuestoRepository;

	@Override
	@Transactional
	public List<Repuesto> findAllRepuesto() {
		// TODO Auto-generated method stub
		Iterable<Repuesto> repuesto = respuestoRepository.findAll();
		List<Repuesto> result = new ArrayList<Repuesto>();
		repuesto.forEach(result::add);
		return result;
	}

	@Override
	public Repuesto findRepuestoById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Repuesto> optional = respuestoRepository.findById(id);		
		return optional.get();
	}

	@Override
	public Repuesto saveOrUpdateRepuesto(Repuesto repuesto) {
		// TODO Auto-generated method stub
		return respuestoRepository.save(repuesto);
	}

	
}
