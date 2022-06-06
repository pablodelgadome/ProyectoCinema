package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Sala;
import com.example.demo.models.SalaModel;


public interface SalaService {

	List<SalaModel> listAllSalas();
	SalaModel transform(Sala sala);
	Sala transform(SalaModel SalaModel); 
	List<SalaModel> findById(int id);
	
}
