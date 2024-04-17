package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Prenda;
import com.example.demo.repository.PrendaRepository;

@Service
public class PrendaService {
	
	@Autowired
	private PrendaRepository prendaRepository;
	
	public List<Prenda> getAllPrendas(){
		return prendaRepository.findAll();
	}
	
	public Prenda savePrenda(Prenda prendaNueva) throws Exception{
		if(validacionesPrenda(prendaNueva)) {
			return prendaRepository.save(prendaNueva);
		}
		else {
			throw new Exception("La prenda no se pudo guardar");
		}
	}
	
	public String deletePrenda(String id) {
		prendaRepository.deleteById(id);
		return("Se ha eliminado la prenda con id: "+ id);
	}
	
	public List<Prenda> getAllPrendasByTalla(String talla) {
		return prendaRepository.findAllByTalla(talla);
	}
	
	public Prenda updatePrenda(String id, Prenda prendaActualizar) throws Exception {
		Optional<Prenda> buscarPrenda = prendaRepository.findById(id);
		if(!buscarPrenda.isPresent()) {
			throw new Exception("La prenda no fue encontrada");
		}
		Prenda prendaExistente = buscarPrenda.get();
		if(validacionesPrenda(prendaActualizar)) {
			prendaExistente.setNombre(prendaActualizar.getNombre());
			prendaExistente.setTalla(prendaActualizar.getTalla());
			prendaExistente.setDescripcion(prendaActualizar.getDescripcion());
			prendaExistente.setPrecio(prendaActualizar.getPrecio());
			prendaExistente.setStock(prendaActualizar.getStock());
			return prendaRepository.save(prendaExistente);
		}else {
			throw new Exception("La prenda no se pudo actualizar");
		}
	}
	
	public Prenda updateDataPrenda(String id, Prenda prendaActualizar) throws Exception {
		Optional<Prenda> buscarPrenda = prendaRepository.findById(id);
		if(!buscarPrenda.isPresent()) {
			throw new Exception("La prenda no fue encontrada");
		}
		Prenda prendaExistente = buscarPrenda.get();
		if (prendaActualizar.getNombre() != null) {
	        prendaExistente.setNombre(prendaActualizar.getNombre());
	    }
		if (prendaActualizar.getTalla() != null) {
	        prendaExistente.setTalla(prendaActualizar.getTalla());
	    }
		if (prendaActualizar.getDescripcion() != null) {
	        prendaExistente.setDescripcion(prendaActualizar.getDescripcion());
	    }
		if (prendaActualizar.getPrecio() != 0) {
	        prendaExistente.setPrecio(prendaActualizar.getPrecio());
	    }
		if (prendaActualizar.getStock() != 0) {
	        prendaExistente.setStock(prendaActualizar.getStock());
	    }
		return prendaRepository.save(prendaExistente);
		
	}
	 
	 public Boolean validacionesPrenda(Prenda prenda) throws Exception {
		 if(prenda.getNombre() == null || prenda.getNombre().isBlank()) {
			 throw new Exception("El nombre de la prenda no puede ser nulo ");
		 }
		 if(prenda.getTalla() == null || prenda.getTalla().isBlank()) {
			 throw new Exception("La talla de la prenda no puede ser nulo ");
		 }
		 if(prenda.getDescripcion() == null || prenda.getDescripcion().isBlank()) {
			 throw new Exception("La descripción de la prenda no puede ser nulo ");
		 }
		 if(prenda.getPrecio()<=0) {
			 throw new Exception("El precio debe ser mayor a 0 ");
		 }
		 if(prenda.getStock()<0) {
			 throw new Exception("El stock debe ser un número positivo ");
		 }
		 return true;
	 }
}
