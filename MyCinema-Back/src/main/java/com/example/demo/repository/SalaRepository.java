package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sala;

@Repository("salaRepository")
public interface SalaRepository extends JpaRepository <Sala, Serializable>{

}
