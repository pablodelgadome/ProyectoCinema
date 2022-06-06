package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Complemento;

@Repository("ComplementoRepository")
public interface ComplementoRepository extends JpaRepository <Complemento, Serializable>{

}
