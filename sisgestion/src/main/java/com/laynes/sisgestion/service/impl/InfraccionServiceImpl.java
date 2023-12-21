package com.laynes.sisgestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laynes.sisgestion.entity.Infraccion;
import com.laynes.sisgestion.repository.InfraccionRepository;
import com.laynes.sisgestion.service.InfraccionService;
import com.laynes.sisgestion.service.impl.InfraccionServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService{
	@Autowired
	private InfraccionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Infraccion> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infraccion findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infraccion findByDni(String dni) {
		try {
			return repository.findByDni(dni);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public Infraccion create(Infraccion obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Infraccion update(Infraccion obj) {
		try {
			Infraccion infraccionDb=findById(obj.getId());
			infraccionDb.setDni(obj.getDni());
			infraccionDb.setFecha(obj.getFecha());
			infraccionDb.setPlaca(obj.getPlaca());
			infraccionDb.setInfraccion(obj.getInfraccion());
			infraccionDb.setDescripcion(obj.getDescripcion());
			return repository.save(infraccionDb);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public int delete(int id) {
		try {
			Infraccion infraccionDb=findById(id);
			if(infraccionDb==null) {
				return 0;
			}else {
				repository.delete(infraccionDb);
				return 1;
			}
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

}
