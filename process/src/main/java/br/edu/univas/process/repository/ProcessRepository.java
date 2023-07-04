package br.edu.univas.process.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.process.entities.ProcessEntity;

@Repository
public class ProcessRepository  extends SimpleJpaRepository<ProcessEntity, Long> {

	public ProcessRepository(Class<ProcessEntity> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}

}
