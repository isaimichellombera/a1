package com.isaim.models;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface AccessDao extends CrudRepository<Access, Long> {

	public Access findById(long id);
}
