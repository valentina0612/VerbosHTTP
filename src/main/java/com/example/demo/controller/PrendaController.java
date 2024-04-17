package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Prenda;
import com.example.demo.service.PrendaService;

@RestController
@RequestMapping("/api/prendas")
public class PrendaController {
	
	@Autowired
    private PrendaService prendaService;

    @GetMapping
    public ResponseEntity<List<Prenda>> getAllPrendas() {
        return new ResponseEntity<List<Prenda>>(prendaService.getAllPrendas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Prenda> createPrenda(@RequestBody Prenda prenda) throws Exception {
        return new ResponseEntity<Prenda>(prendaService.savePrenda(prenda), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prenda> updatePrenda(@PathVariable String id, @RequestBody Prenda prenda) throws Exception {
        return new ResponseEntity<Prenda>(prendaService.updatePrenda(id, prenda), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrenda(@PathVariable String id) {
        String mensaje = prendaService.deletePrenda(id);
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/talla/{talla}")
    public ResponseEntity<List<Prenda>> getAllPrendasByTalla(@PathVariable String talla) {
        return new ResponseEntity<List<Prenda>>(prendaService.getAllPrendasByTalla(talla),  HttpStatus.OK);
    }
    
    @PatchMapping("/updateData/{id}")
    public ResponseEntity<Prenda> updateData(@PathVariable String id, @RequestBody Prenda prenda) throws Exception{
        return new ResponseEntity<Prenda>(prendaService.updateDataPrenda(id, prenda),HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> Options() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ALLOW, "GET, POST, PATCH, PUT, DELETE, OPTIONS"); 

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
	
}
