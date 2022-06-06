package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Entrada;
import com.example.demo.entity.Sala;
import com.example.demo.models.EntradaModel;

public interface EntradaService {

	List<EntradaModel> listAll();
	List<EntradaModel> listAllEntradas();
	List<EntradaModel> findBySala(Sala sala);
	Entrada addEntrada(EntradaModel entrada);
	EntradaModel transform(Entrada Entrada);
	
}
