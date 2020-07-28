package pe.com.minol.core.services;

import java.util.List;

import pe.com.minol.core.entities.Maquina;

public interface MaquinaService {

		List<Maquina> findAllMaquina();
		Maquina findMaquinaById(Integer id);
		
		Maquina saveOrUpdateMaquina(Maquina maquina);
}
