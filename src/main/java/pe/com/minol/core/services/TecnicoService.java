package pe.com.minol.core.services;

import java.util.List;

import pe.com.minol.core.entities.Tecnico;

public interface TecnicoService {

		List<Tecnico> findAllTecnico();
		Tecnico findTecnicoById(Integer id);
		Tecnico saveOrUpdateTecnico(Tecnico tecnico);
}
