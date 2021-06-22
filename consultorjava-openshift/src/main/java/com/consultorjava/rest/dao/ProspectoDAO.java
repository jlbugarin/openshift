package com.consultorjava.rest.dao;

import org.springframework.stereotype.Repository;

import com.consultorjava.rest.model.Prospecto;
import com.consultorjava.rest.model.Prospectos;

@Repository
public class ProspectoDAO {

	private static Prospectos list = new Prospectos();

	static {
		list.getProspectoLista().add(new Prospecto(1, "Paolo", "Guerrero", "depredador@gmail.com"));
		list.getProspectoLista().add(new Prospecto(2, "Edinson", "Flores", "orejas@gmail.com"));
		list.getProspectoLista().add(new Prospecto(3, "Pedro", "gallese", "eltenista@gmail.com"));
	}

	public Prospectos getAllProspectos() {
		return list;
	}

	public void addProspecto(Prospecto prospecto) {
		list.getProspectoLista().add(prospecto);
	}

}
