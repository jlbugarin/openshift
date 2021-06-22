package com.consultorjava.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Prospectos {

	private List<Prospecto> listaProspectos;

	public List<Prospecto> getProspectoLista() {
		if (listaProspectos == null) {
			listaProspectos = new ArrayList<Prospecto>();
		}
		return listaProspectos;
	}

	public void setListaProspectos(List<Prospecto> listaProspectos) {
		this.listaProspectos = listaProspectos;
	}

}
