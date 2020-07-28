package pe.com.minol.core.services;

import java.util.List;

import pe.com.minol.core.entities.Repuesto;

public interface RepuestoService {

		List<Repuesto> findAllRepuesto();
		Repuesto findRepuestoById(Integer id);
		Repuesto saveOrUpdateRepuesto(Repuesto repuesto);
}
