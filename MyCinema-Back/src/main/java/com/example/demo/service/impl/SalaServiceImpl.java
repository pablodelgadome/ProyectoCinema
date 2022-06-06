package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sala;
import com.example.demo.models.SalaModel;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;

@Service("salaService")
public class SalaServiceImpl implements SalaService{

	@Autowired
	@Qualifier("salaRepository")
	private SalaRepository SalaRepository;

	public SalaModel transform(Sala Sala) 
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Sala, SalaModel.class);
	}
	
	public Sala transform(SalaModel Salamodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Salamodel, Sala.class);
	}
	
	public List<SalaModel> listAllSalas() {
		return SalaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}


	@Override
	public List<SalaModel> findById(int id) {
		return SalaRepository.findById(id).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}
	
}
