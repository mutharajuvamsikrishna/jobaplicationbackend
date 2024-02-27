package com.web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.PerEmp;

@Repository
public interface PerEmpRepo extends CrudRepository<PerEmp, Long> {

	PerEmp findByEmail(String email);

	List<PerEmp> findAll();

	PerEmp deleteByEmail(String email);

}
