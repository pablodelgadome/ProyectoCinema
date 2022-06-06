package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Complemento;
import com.example.demo.models.ComplementoModel;
import com.example.demo.repository.ComplementoRepository;
import com.example.demo.service.ComplementoService;

@Service("complementoService")
public class ComplementoServiceImpl implements ComplementoService{

	@Autowired
	@Qualifier("ComplementoRepository")
	private ComplementoRepository complementoRepository;

	@Override
	public ComplementoModel transform(Complemento Complemento)
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Complemento, ComplementoModel.class);
	}
	
	@Override
	public Complemento transform(ComplementoModel Complementomodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Complementomodel, Complemento.class);
	}
	
	@Override
	public List<ComplementoModel> listAllComplementos() {
		return complementoRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}

	@Override
	public Complemento addComplemento(ComplementoModel ComplementoModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeComentario(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Complemento updateComplento(ComplementoModel ComplementoModel) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
