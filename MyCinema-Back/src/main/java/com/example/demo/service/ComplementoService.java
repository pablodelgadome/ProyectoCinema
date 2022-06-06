package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Complemento;
import com.example.demo.models.ComplementoModel;


public interface ComplementoService {

	List<ComplementoModel> listAllComplementos();
	Complemento addComplemento(ComplementoModel ComplementoModel);
	int removeComentario(int id);
	Complemento updateComplento(ComplementoModel ComplementoModel);
	ComplementoModel transform(Complemento Complemento);
	Complemento transform(ComplementoModel Complementomodel);
	
}
