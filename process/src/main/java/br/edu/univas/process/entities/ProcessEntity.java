package br.edu.univas.process.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String responsible;
	private String lastReview;
	private Integer qualityRate;
	private String probabilityNewDeals;
	private boolean active;

}
