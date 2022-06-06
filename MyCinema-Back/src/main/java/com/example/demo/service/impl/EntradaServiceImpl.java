package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Entrada;
import com.example.demo.entity.Sala;
import com.example.demo.models.EntradaModel;
import com.example.demo.repository.EntradaRepository;
import com.example.demo.service.EntradaService;

@Service("EntradaService")
public class EntradaServiceImpl implements EntradaService{
	
	@Autowired
	@Qualifier("EntradaRepository")
	private EntradaRepository entradaRepository;
	
	public EntradaModel transform(Entrada Entrada) 
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Entrada, EntradaModel.class);
	}
	
	public Entrada transform(EntradaModel Entradamodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Entradamodel, Entrada.class);
	}
	
	@Override
	public List<EntradaModel> listAll() {
		return entradaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<EntradaModel> listAllEntradas() {
		return entradaRepository.historial().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<EntradaModel> findBySala(Sala sala) {
		return entradaRepository.findBySala(sala).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Entrada addEntrada(EntradaModel entrada) {
		return entradaRepository.save(transform(entrada));
	}


}
