package com.laynes.sisgestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.laynes.sisgestion.entity.Infraccion;


@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{
	public Infraccion findByDni(String dni);
	public List<Infraccion> findByDniContaining(String dni);
}
