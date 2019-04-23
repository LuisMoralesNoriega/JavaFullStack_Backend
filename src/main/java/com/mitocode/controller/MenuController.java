package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
		
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	@GetMapping(value = "/{id}", produces = "application/json")
	public Menu listarPorId(@PathVariable("id") Integer id) {
		return service.listarId(id);
	}
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public Menu registrar(@RequestBody Menu menu) {
		return service.registrar(menu);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	public Menu modificar(@RequestBody Menu menu) {
		return service.modificar(menu);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
	
}
