package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Pelicula;
import com.example.demo.models.ComentarioModel;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.service.ComentarioService;

import org.modelmapper.ModelMapper;

@Service("ComentarioService")
public class ComentarioServiceImpl implements ComentarioService{
		
		@Autowired
		private ComentarioRepository ComentarioRepository;

		public ComentarioModel transform(Comentario Comentario) 
		{
			ModelMapper modelmapper = new ModelMapper();
			return modelmapper.map(Comentario, ComentarioModel.class);
		}
		
		public Comentario transform(ComentarioModel Comentariomodel)
		{
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(Comentariomodel, Comentario.class);
		}
		
		
		public List<ComentarioModel> listAllComentarios() {
			return ComentarioRepository.findAll().stream()
					.map(c->transform(c)).collect(Collectors.toList());
		}

		public Comentario addComentario(ComentarioModel ComentarioModel) {
			return ComentarioRepository.save(transform(ComentarioModel));
		}

		public int removeComentario(int id) {
			ComentarioRepository.deleteById(id);
			return 0;
		}

		public Comentario updateComentario(ComentarioModel ComentarioModel) {
			return ComentarioRepository.save(transform(ComentarioModel));
		}

		@Override
		public List<ComentarioModel> findByPelicula(Pelicula pelicula) {
			return ComentarioRepository.findByPelicula(pelicula).stream()
					.map(c->transform(c)).collect(Collectors.toList());
		}

		@Override
		public Comentario addComentario(Comentario comentario) {
			return ComentarioRepository.save(comentario);
		}
	
}
