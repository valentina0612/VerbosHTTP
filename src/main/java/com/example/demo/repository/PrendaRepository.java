package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Prenda;

@Repository
public interface PrendaRepository extends MongoRepository<Prenda, String> {
	
	Prenda findByNombre(String nombre);
	
	List<Prenda> findAll();
	
	List<Prenda> findAllByTalla(String talla);
}
