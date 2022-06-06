package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pelicula;
import com.example.demo.models.PeliculaModel;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.PeliculaService;

@Service("peliculaService")
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	@Qualifier("peliculaRepository")
	private PeliculaRepository peliculaRepository;

	@Override
	public PeliculaModel transform(Pelicula Pelicula) 
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Pelicula, PeliculaModel.class);
	}
	
	@Override
	public Pelicula transform(PeliculaModel Peliculamodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Peliculamodel, Pelicula.class);
	}
	
	@Override
	public List<PeliculaModel> listAllPeliculas() {
		return peliculaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}

	@Override
	public Pelicula addPelicula(PeliculaModel peliculaModel) {
		return peliculaRepository.save(transform(peliculaModel));
	}

	@Override
	public int removePelicula(int id) {
		peliculaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Pelicula updatePelicula(PeliculaModel peliculaModel) {
		return peliculaRepository.save(transform(peliculaModel));
	}
	
	@Override
	public List<PeliculaModel> findByCategoria(String categoria) {
		return peliculaRepository.findByCategoria(categoria).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public List<PeliculaModel> findByTitulo(String titulo) {
		return peliculaRepository.findByTitulo(titulo).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public PeliculaModel findPelicula(int id) {
		return transform(peliculaRepository.findById(id).orElse(null));
	}
	
}
