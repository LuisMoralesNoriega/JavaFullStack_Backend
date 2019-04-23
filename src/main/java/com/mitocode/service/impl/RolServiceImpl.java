package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDAO dao;

	@Override
	public Rol registrar(Rol rol) {
		return dao.save(rol);
	}

	@Override
	public Rol modificar(Rol rol) {
		return dao.save(rol);
	}

	@Override
	public void eliminar(int idrol) {
		dao.delete(idrol);		
	}

	@Override
	public Rol listarId(int idrol) {
		return dao.findOne(idrol);
	}

	@Override
	public List<Rol> listar() {
		return dao.findAll();
	}
	
	
}
