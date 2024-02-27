package com.web.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.OnieJobId;

@Repository
public interface OnieJobIdRepo extends CrudRepository<OnieJobId, Long> {
	ArrayList<OnieJobId> findAll();
}
