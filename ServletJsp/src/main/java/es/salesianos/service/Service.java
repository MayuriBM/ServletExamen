package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Paises;
import es.salesianos.model.assembler.PaisesAssembler;

public class Service {


	public Paises assemblePaisesFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return PaisesAssembler.assemblePaisesFrom(req);
	}

	
}
