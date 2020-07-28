package pe.com.minol.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.minol.core.entities.Maquina;



@Repository
public interface MaquinaRepository extends CrudRepository<Maquina, Integer> {
	
	

}
