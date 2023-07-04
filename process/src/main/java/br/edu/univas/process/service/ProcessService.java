package br.edu.univas.process.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.process.entities.ProcessEntity;
import br.edu.univas.process.processDto.ProcessDTO;
import br.edu.univas.process.repository.ProcessRepository;
import br.edu.univas.process.support.ObjectNotFoundException;

@Service
public class ProcessService {
	
	private ProcessRepository repo;

	@Autowired
	public ProcessService(ProcessRepository repo) {
		this.repo = repo;
	}

	public ProcessEntity findById(Long code) {
		Optional<ProcessEntity> obj = repo.findById(code);
		ProcessEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Process " + code + " not found"));
		return entity;
	}

	public void createProduct(ProcessDTO process) {
		repo.save(toEntity(process));
	}

	public ProcessEntity toEntity(ProcessDTO processDTO) {
		return new ProcessEntity(
				processDTO.getCode(), 
				processDTO.getResponsible(), 
				processDTO.getLastReview(),
				processDTO.getQualityRate(), 
				processDTO.getProbabilityNewDeals(), 
				processDTO.isActive()
				);
	}

}
