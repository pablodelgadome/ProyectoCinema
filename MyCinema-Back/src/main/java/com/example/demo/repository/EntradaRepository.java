package com.example.demo.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Entrada;
import com.example.demo.entity.Sala;

@Repository("EntradaRepository")
public interface EntradaRepository extends JpaRepository <Entrada, Serializable>{

	@Query(value="SELECT * FROM ENTRADA WHERE FECHA < CURRENT_DATE()", nativeQuery = true)
	List<Entrada> historial();

	List<Entrada> findBySala(Sala sala);
	
	
}
