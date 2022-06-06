package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Pelicula;

@Repository("ComentarioRepository")
public interface ComentarioRepository extends JpaRepository <Comentario, Serializable>{

	List<Comentario> findByPelicula(Pelicula pelicula);
	
}
