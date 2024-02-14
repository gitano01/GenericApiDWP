package com.api.centrocostos.dto.api.utils;

import java.util.List;

import lombok.Data;

@Data
public class Modulo {
	private String main;
	private List<Ruta> apartados;
	
	public Modulo(){};
	
	
}
